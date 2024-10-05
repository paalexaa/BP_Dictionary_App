package com.example.myapplication.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.UI.Adapters.Adapter
import com.example.myapplication.UI.Adapters.WordAdapter
import com.example.myapplication.ViewModel.WordViewModel
import com.example.myapplication.WordDatabase.WordDao
import com.example.myapplication.WordDatabase.WordEntity
import com.example.myapplication.databinding.FragmentWordPageBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WordPage : Fragment() {

    private val wordViewModel: WordViewModel by viewModels()
    private lateinit var binding: FragmentWordPageBinding
    private lateinit var wordsList: List<WordEntity>

    @Inject
    lateinit var wordDao: WordDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWordPageBinding.inflate(inflater, container, false)

        binding.backArrowWords.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val subjectName = arguments?.getString("subjectName")
        binding.subjectsListName.text = subjectName ?: "Subject Name"

        subjectName?.let {
            wordViewModel.getWordsBySubject(it).observe(viewLifecycleOwner, Observer { words ->
                wordsList = words
                val adapter = WordAdapter(requireContext(), ArrayList(words))
                binding.wordList.adapter = adapter
            })
        }

        binding.wordList.setOnItemClickListener { parent, view, position, id ->
            val selectedWord = wordsList[position]

            val translationFragment = DetailedTranslation()

            val bundle = Bundle().apply {
                putString("wordName", selectedWord.wordName)
                putString("translations", selectedWord.translations)
                putString("exampleSentences", selectedWord.exampleSentences)
                putString("wordLink", selectedWord.wordLink)
            }
            translationFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_wordpage, translationFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = wordsList.filter {
                    it.wordName.startsWith(newText ?: "", ignoreCase = true)
                }
                val adapter = WordAdapter(requireContext(), ArrayList(filteredList))
                binding.wordList.adapter = adapter
                return true
            }
        })

        return binding.root
    }
}