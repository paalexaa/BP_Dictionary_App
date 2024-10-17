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
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentTranslatorBinding
import com.example.myapplication.viewmodel.TranslatorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Translator : Fragment() {

    private lateinit var binding: FragmentTranslatorBinding
    private var items = arrayOf("Slovenčina", "Ukrajinčina", "Angličtina")
    private val viewModel: TranslatorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTranslatorBinding.inflate(inflater, container, false)

        val itemsAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, items)
        binding.languageFrom.setAdapter(itemsAdapter)
        binding.languageTo.setAdapter(itemsAdapter)

        setupObservers()

        binding.button.setOnClickListener {
            val selectFrom = viewModel.selectFrom(binding.languageFrom.text.toString())
            val selectTo = viewModel.selectTo(binding.languageTo.text.toString())
            viewModel.translateText(selectFrom, selectTo, binding.input.text.toString())
        }

        binding.swap.setOnClickListener {
            swapLanguages()
        }

//        binding.micButton.setOnClickListener {
//            val languageCode = viewModel.selectFrom(binding.languageFrom.text.toString())
//            viewModel.startVoiceRecognition(languageCode)
//        }

        return binding.root
    }

    private fun setupObservers() {
        viewModel.translatedText.observe(viewLifecycleOwner) {
            binding.output.text = it
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

//        viewModel.speechResult.observe(viewLifecycleOwner) {
//            if (it != null && it.isNotEmpty()) {
//                binding.input.setText(it.first())
//            }
//        }
//
//        viewModel.speechError.observe(viewLifecycleOwner) {
//            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
//        }
    }

//    private fun startVoiceRecognition(languageCode: String) {
//        val intent = viewModel.startVoiceRecognition(languageCode)
//        startActivityForResult(intent, 100)
//    }
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        viewModel.speechResult(requestCode, resultCode, data)
//    }

    private fun swapLanguages() {
        val fromLanguage = binding.languageFrom.text.toString()
        val toLanguage = binding.languageTo.text.toString()

        binding.languageFrom.setText(toLanguage, false)
        binding.languageTo.setText(fromLanguage, false)
    }
}