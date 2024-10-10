package com.example.myapplication.wordDatabase

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
object WordDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase (
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        WordDatabase::class.java,
        "words"
    )
        .createFromAsset("database/words.db")
        .build()

    @Singleton
    @Provides
    fun provideWordDao(database: WordDatabase) = database.getWordDao()
}