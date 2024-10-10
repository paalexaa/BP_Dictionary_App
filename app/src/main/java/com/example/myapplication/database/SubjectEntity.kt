package com.example.myapplication.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
data class Subjects(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)