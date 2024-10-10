package com.example.myapplication.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase (
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        SubjectDatabase::class.java,
        "subjects"
    )
        .createFromAsset("database/subjects.db")
        .build()

    @Singleton
    @Provides
    fun provideDao(database: SubjectDatabase) = database.getSubjectDao()
}