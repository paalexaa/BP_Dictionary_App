package com.example.myapplication

data class Word_DB(
    var wordName: String,
    val difficulty: Difficulty,
    val translations: List<String>,
    val exampleSentences: List<String>,
    val wordLink: String)

enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}
