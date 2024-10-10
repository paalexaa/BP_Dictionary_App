package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.database.SubjectDao
import com.example.myapplication.database.Subjects
import javax.inject.Inject

class SubjectRepository @Inject constructor(
    private val subjectDao: SubjectDao
){
    val getSubjects: LiveData<List<Subjects>> = subjectDao.getAllSubjects()
}