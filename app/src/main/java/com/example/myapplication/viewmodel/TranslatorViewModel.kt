package com.example.myapplication.viewmodel

import android.content.Intent
import android.speech.RecognizerIntent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.MyApplication
import com.example.myapplication.repository.TranslatorRepository
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TranslatorViewModel  @Inject constructor(
    private val translatorRepository: TranslatorRepository
): ViewModel() {

    private val _translatedText = MutableLiveData<String>()
    val translatedText: LiveData<String> get() = _translatedText

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

//    private val _speechResult = MutableLiveData<List<String>>()
//    val speechResult: LiveData<List<String>> get() = _speechResult
//
//    private val _speechError = MutableLiveData<String>()
//    val speechError: LiveData<String> get() = _speechError

    private var conditions = DownloadConditions.Builder().requireWifi().build()

    fun translateText(selectFrom: String, selectTo: String, input: String) {

        val options = translatorRepository.getTranslatorOptions(selectFrom, selectTo)
        val translator = Translation.getClient(options)

        translator.downloadModelIfNeeded(conditions)
            .addOnSuccessListener {
                translator.translate(input)
                    .addOnSuccessListener { translation ->
                        _translatedText.postValue(translation)
                    }
                    .addOnFailureListener { error ->
                        _errorMessage.postValue(error.message)
                    }
            }
            .addOnFailureListener { error ->
                _errorMessage.postValue(error.message)
            }
    }

//    fun startVoiceRecognition(languageCode: String): Intent {
//        return Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
//            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
//            putExtra(RecognizerIntent.EXTRA_LANGUAGE, languageCode)
//            putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak now...")
//        }
//    }
//
//    fun speechResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (requestCode == 100 && resultCode == AppCompatActivity.RESULT_OK) {
//            val result = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
//            if (!result.isNullOrEmpty()) {
//                _speechResult.postValue(result)
//            } else {
//                _speechError.postValue("No speech recognized")
//            }
//        } else {
//            _speechError.postValue("Error recognizing speech")
//        }
//    }

    fun selectFrom(language: String): String {
        return when (language) {
            "" -> TranslateLanguage.SLOVAK
            "Slovenčina" -> TranslateLanguage.SLOVAK
            "Ukrajinčina" -> TranslateLanguage.UKRAINIAN
            "Angličtina" -> TranslateLanguage.ENGLISH
            else -> TranslateLanguage.SLOVAK
        }
    }

    fun selectTo(language: String): String {
        return when (language) {
            "" -> TranslateLanguage.UKRAINIAN
            "Slovenčina" -> TranslateLanguage.SLOVAK
            "Ukrajinčina" -> TranslateLanguage.UKRAINIAN
            "Angličtina" -> TranslateLanguage.ENGLISH
            else -> TranslateLanguage.UKRAINIAN
        }
    }
}