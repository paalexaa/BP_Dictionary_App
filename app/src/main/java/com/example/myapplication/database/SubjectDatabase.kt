package com.example.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Subjects::class], version = 1)
abstract class SubjectDatabase : RoomDatabase() {
    abstract fun getSubjectDao(): SubjectDao
}
