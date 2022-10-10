package com.udacity.asteroidradar.di

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Room
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.udacity.asteroidradar.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
/*
    @Provides
    @Singleton
    fun provideApplicationDatabase(@ApplicationContext app: Context): AppDatabase =
        AppDatabase.getDatabase(context = app)
//        Room.databaseBuilder(app, AppDatabase::class.java, "asteroid_table")
//            .allowMainThreadQueries()
//            .fallbackToDestructiveMigration().build()

*/

    @Provides
    @Singleton
    fun provideApplicationDatabase(@ApplicationContext app: Context): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "asteroid_table").addTypeConverter(com.udacity.asteroidradar.data.local.Converters()).allowMainThreadQueries().build()

    @Provides
    @Singleton
    fun provideAsteroidDao(db: AppDatabase) = db.AsteroidDao()

    @Provides
    @Singleton
    fun providePictureOfTodayDao(db: AppDatabase) = db.PictureOfTodayDao()
}