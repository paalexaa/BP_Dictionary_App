package com.example.myapplication.wordDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val wordName: String,
    val difficulty: Int,
    val translations: String,
    val exampleSentences: String,
    val wordLink: String,
    val subject: String
)
