package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.WordRepository
import com.example.myapplication.wordDatabase.WordEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordViewModel @Inject constructor(
    private val wordRepository: WordRepository
): ViewModel() {

    fun getWordsBySubject(subjectName: String): LiveData<List<WordEntity>> {
        return wordRepository.getWordsBySubject(subjectName)
    }
}
