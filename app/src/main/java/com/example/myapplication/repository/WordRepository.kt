package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.wordDatabase.WordDao
import com.example.myapplication.wordDatabase.WordEntity
import javax.inject.Inject

class WordRepository @Inject constructor(
    private val wordDao: WordDao
){
    fun getWordsBySubject(subjectName: String): LiveData<List<WordEntity>> = wordDao.getWordsBySubject(subjectName)

    fun getWordById(wordId: Int): LiveData<WordEntity> = wordDao.getWordById(wordId)
}