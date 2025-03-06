package com.example.myapplication.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSettingsBinding
import com.example.myapplication.databinding.FragmentWordPageBinding
import com.example.myapplication.wordDatabase.WordDao
import com.example.myapplication.wordDatabase.WordEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class Settings : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    private var currentWord: WordEntity? = null
    private var isTranslationVisible = false

    @Inject
    lateinit var wordDao: WordDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        binding.tvTranslation.visibility = View.GONE

        wordDao.getRandomWord().observe(viewLifecycleOwner, { randomWord ->
            if (randomWord != null) {
                displayWord(randomWord)
            }
        })

        binding.tvCardView.setOnClickListener {
            wordDao.getRandomWord().observe(viewLifecycleOwner, { randomWord ->
                if (randomWord != null) {
                    currentWord = randomWord
                    binding.tvWord.text = randomWord.wordName
                    binding.tvTranslation.text = randomWord.translations

                    binding.tvTranslation.visibility = View.GONE
                    binding.tvWord.visibility = View.VISIBLE
                    isTranslationVisible = false
                }
            })
        }

        binding.button.setOnClickListener {
            if (isTranslationVisible) {
                binding.tvTranslation.visibility = View.GONE
                binding.tvWord.visibility = View.VISIBLE
            } else {
                binding.tvTranslation.visibility = View.VISIBLE
                binding.tvWord.visibility = View.GONE
            }
            isTranslationVisible = !isTranslationVisible
        }

        return binding.root
    }
    private fun displayWord(randomWord: WordEntity) {
        binding.tvWord.text = randomWord.wordName
        binding.tvTranslation.text = randomWord.translations
    }
}