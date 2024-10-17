package com.example.myapplication.repository

import android.content.Context
import com.google.mlkit.nl.translate.TranslatorOptions
import javax.inject.Inject

class TranslatorRepository @Inject constructor(private val context: Context) {

    fun getTranslatorOptions(selectFrom: String, selectTo: String) : TranslatorOptions {
        return TranslatorOptions.Builder()
            .setSourceLanguage(selectFrom)
            .setTargetLanguage(selectTo)
            .build()
    }
}