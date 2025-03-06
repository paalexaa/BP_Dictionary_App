package com.example.myapplication.wordDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface WordDao {

    @Query("SELECT * FROM words WHERE subject = :subjectName")
    fun getWordsBySubject(subjectName: String): LiveData<List<WordEntity>>

    @Query("SELECT * FROM words WHERE id = :wordId LIMIT 1")
    fun getWordById(wordId: Int): LiveData<WordEntity>

    @Query("SELECT * FROM words ORDER BY RANDOM() LIMIT 1")
    fun getRandomWord(): LiveData<WordEntity>
}