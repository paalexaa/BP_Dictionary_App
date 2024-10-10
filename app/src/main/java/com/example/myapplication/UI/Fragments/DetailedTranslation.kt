package com.example.myapplication.UI.Fragments

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.myapplication.ViewModel.DetailedTranslationViewModel
import com.example.myapplication.WordDatabase.WordDao
import com.example.myapplication.WordDatabase.WordEntity
import com.example.myapplication.databinding.FragmentDetailedTranslationBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
class DetailedTranslation : Fragment(), TextToSpeech.OnInitListener {

    private lateinit var binding: FragmentDetailedTranslationBinding
    private lateinit var textToSpeech: TextToSpeech
    private val viewModel: DetailedTranslationViewModel by viewModels()

    @Inject
    lateinit var wordDao: WordDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailedTranslationBinding.inflate(inflater, container, false)

        binding.backArrowTranslation.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.copyButton.setOnClickListener {
            val textToCopy = binding.wordSk.text.toString()

            val clipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

            val clip = ClipData.newPlainText("Copied Text", textToCopy)

            clipboard.setPrimaryClip(clip)

            Toast.makeText(requireContext(), "Text copied to clipboard", Toast.LENGTH_SHORT).show()
        }

        textToSpeech = TextToSpeech(requireContext(), this)
        binding.speechButton.setOnClickListener {
            val wordToPronounce = binding.wordSk.text.toString()
            speakWord(wordToPronounce)
        }

//        val wordLink = arguments?.getString("wordLink")
//        binding.linkButton.setOnClickListener {
//            wordLink?.let { link ->
//                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
//                startActivity(intent)
//            }
//        }

        val wordId = arguments?.getInt("wordId") ?: return binding.root
        wordDetails(wordId)


//        val word = arguments?.getString("wordName")
//        binding.wordSk.text = word ?: "Word Name"
//
//        val translations = arguments?.getStringArrayList("translations")
//        binding.meaningBn.text = translations?.joinToString(", ") ?: "No translations available"
//
//        val exampleSentences = arguments?.getStringArrayList("exampleSentences")
//        binding.example.text = exampleSentences?.joinToString("\n") ?: "No example sentences available"

        return binding.root
    }

    private fun wordDetails(wordId: Int) {
        viewModel.getWordById(wordId).observe(viewLifecycleOwner) { wordEntity ->
            bindWordDetails(wordEntity)
        }
    }
    private fun bindWordDetails(wordEntity: WordEntity?) {
        wordEntity?.let {word ->
            binding.wordSk.text = word.wordName
            binding.meaningBn.text = word.translations
            binding.example.text = word.exampleSentences
            binding.linkButton.setOnClickListener {
                val wordLink = word.wordLink
                if (wordLink.isNotEmpty()) {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(wordLink))
                    startActivity(intent)
                } else {
                    Toast.makeText(requireContext(), "No link available", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech.setLanguage(Locale("sk"))

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(requireContext(), "Slovak language not supported", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(requireContext(), "TextToSpeech initialization failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun speakWord(wordToPronounce: String) {
        textToSpeech.speak(wordToPronounce, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    override fun onDestroy() {
        if (::textToSpeech.isInitialized) {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
        super.onDestroy()
    }

}