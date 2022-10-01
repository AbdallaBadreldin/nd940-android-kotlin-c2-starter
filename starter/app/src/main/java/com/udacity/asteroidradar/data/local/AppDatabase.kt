package com.udacity.asteroidradar.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.udacity.asteroidradar.domain.models.Asteroid
import com.udacity.asteroidradar.domain.models.PictureOfDay
import javax.inject.Singleton


@Database(entities = [Asteroid::class, PictureOfDay::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun AsteroidDao(): AsteroidDao
    abstract fun PictureOfTodayDao(): PictureOfTodayDao


    @Singleton
    companion object {
        // Singleton prevents multiple
        // instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }


}