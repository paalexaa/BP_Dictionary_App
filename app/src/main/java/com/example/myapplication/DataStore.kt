package com.example.myapplication

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

private val Context.dataStore by preferencesDataStore(name = "wordInfo")

class DataStore(context: Context) {

    private val dataStore = context.dataStore

    object PreferencesKeys {
        val WORD_NAME = stringPreferencesKey("word_name")
        val DIFFICULTY = intPreferencesKey("difficulty")
        val TRANSLATIONS = stringPreferencesKey("translations")
        val EXAMPLE_SENTENCES = stringPreferencesKey("example_sentences")
        val WORD_LINK = stringPreferencesKey("word_link")
    }

    fun saveWordData(
        wordName: String,
        difficulty: Int,
        translations: List<String>,
        exampleSentences: List<String>,
        wordLink: String
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            dataStore.edit { preferences ->
                preferences[PreferencesKeys.WORD_NAME] = wordName
                preferences[PreferencesKeys.DIFFICULTY] = difficulty
                preferences[PreferencesKeys.TRANSLATIONS] = translations.joinToString(",")
                preferences[PreferencesKeys.EXAMPLE_SENTENCES] = exampleSentences.joinToString(",")
                preferences[PreferencesKeys.WORD_LINK] = wordLink
            }
        }
    }

    fun getTranslationData(): Flow<Word_DB> {
        return dataStore.data.map { preferences ->
            val wordName = preferences[PreferencesKeys.WORD_NAME] ?: ""
            val difficulty = preferences[PreferencesKeys.DIFFICULTY] ?: 0
            val translations = preferences[PreferencesKeys.TRANSLATIONS]?.split(",") ?: emptyList()
            val exampleSentences = preferences[PreferencesKeys.EXAMPLE_SENTENCES]?.split(",") ?: emptyList()
            val wordLink = preferences[PreferencesKeys.WORD_LINK] ?: ""

            Word_DB(
                wordName = wordName,
                difficulty = Difficulty.values()[difficulty],
                translations = translations,
                exampleSentences = exampleSentences,
                wordLink = wordLink
            )
        }
    }

    data class WordData(
        val wordName: String,
        val difficulty: Int,
        val translations: List<String>,
        val exampleSentences: List<String>,
        val wordLink: String
    )
}