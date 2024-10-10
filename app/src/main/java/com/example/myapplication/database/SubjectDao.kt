package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface SubjectDao {

    @Query("SELECT * FROM subjects")
    fun getAllSubjects(): LiveData<List<Subjects>>
}
