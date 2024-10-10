package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.SubjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SubjectViewModel @Inject constructor(
    private val subjectRepository: SubjectRepository
): ViewModel() {
    val getSubjects = subjectRepository.getSubjects
}