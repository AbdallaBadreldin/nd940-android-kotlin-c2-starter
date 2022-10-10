package com.udacity.asteroidradar.data.local

import androidx.room.Database
import androidx.room.ProvidedTypeConverter
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.udacity.asteroidradar.domain.models.Asteroid
import com.udacity.asteroidradar.domain.models.PictureOfDay

@TypeConverters(Converters::class)
@Database(entities = [Asteroid::class, PictureOfDay::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun AsteroidDao(): AsteroidDao
    abstract fun PictureOfTodayDao(): PictureOfTodayDao
}
/*   @Singleton
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
                   "asteroid_table"
               ).addTypeConverter(typeConverter = Converters::class)
                   .build()
               INSTANCE = instance
               // return instance
               instance
           }
       }
   }


}*/