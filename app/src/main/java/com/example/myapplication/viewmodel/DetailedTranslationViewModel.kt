package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.WordRepository
import com.example.myapplication.wordDatabase.WordEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailedTranslationViewModel @Inject constructor(
    private val wordRepository: WordRepository
) : ViewModel() {

    fun getWordById(wordId: Int): LiveData<WordEntity> {
        return wordRepository.getWordById(wordId)
    }
}