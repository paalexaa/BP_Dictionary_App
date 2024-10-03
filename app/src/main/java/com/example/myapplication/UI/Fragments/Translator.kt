package com.example.myapplication.UI.Fragments

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.FragmentTranslatorBinding
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions

class Translator : Fragment() {

    private lateinit var binding: FragmentTranslatorBinding
    private var items = arrayOf("Slovenčina", "Ukrajinčina", "Angličtina")
    private var conditions = DownloadConditions.Builder().requireWifi().build()
    private val speechRecognizer: SpeechRecognizer by lazy {
        SpeechRecognizer.createSpeechRecognizer(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTranslatorBinding.inflate(inflater, container, false)

        val itemsAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items)

        binding.languageFrom.setAdapter(itemsAdapter)
        binding.languageTo.setAdapter(itemsAdapter)

        binding.button.setOnClickListener {
            val options = TranslatorOptions.Builder()
                .setSourceLanguage(selectFrom())
                .setTargetLanguage(selectTo())
                .build()

            val translator = Translation.getClient(options)

            translator.downloadModelIfNeeded(conditions)
                .addOnSuccessListener {
                    translator.translate(binding.input.text.toString())
                        .addOnSuccessListener {
                            binding.output.text = it
                        }
                        .addOnFailureListener {
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                        }
                }
                .addOnFailureListener {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
        }

        binding.swap.setOnClickListener {
            swapLanguages()
        }

        binding.micButton.setOnClickListener {
            startVoiceRecognition()
        }

        return binding.root
    }

    private fun swapLanguages() {
        val fromLanguage = binding.languageFrom.text.toString()
        val toLanguage = binding.languageTo.text.toString()

        binding.languageFrom.setText(toLanguage, false)
        binding.languageTo.setText(fromLanguage, false)
    }


    private fun selectFrom(): String {
        return when (binding.languageFrom.text.toString()) {

            "" -> TranslateLanguage.SLOVAK
            "Slovenčina" -> TranslateLanguage.SLOVAK
            "Ukrajinčina" -> TranslateLanguage.UKRAINIAN
            "Angličtina" -> TranslateLanguage.ENGLISH
            else -> TranslateLanguage.SLOVAK
        }
    }

    private fun selectTo(): String {
        return when (binding.languageTo.text.toString()) {

            "" -> TranslateLanguage.UKRAINIAN
            "Slovenčina" -> TranslateLanguage.SLOVAK
            "Ukrajinčina" -> TranslateLanguage.UKRAINIAN
            "Angličtina" -> TranslateLanguage.ENGLISH
            else -> TranslateLanguage.UKRAINIAN
        }
    }

    private fun startVoiceRecognition() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, selectFrom())
            putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak now...")
        }
        startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SPEECH_INPUT && resultCode == AppCompatActivity.RESULT_OK) {
            val result = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            if (!result.isNullOrEmpty()) {
                binding.input.setText(result[0])
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_SPEECH_INPUT = 100
    }
}