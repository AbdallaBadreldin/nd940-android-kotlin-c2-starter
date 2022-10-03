package com.udacity.asteroidradar.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.asteroidradar.domain.models.PictureOfDay

@Dao
interface PictureOfTodayDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAsteroid(picOfToday: PictureOfDay)

    @Query("SELECT * FROM PictureOfDay ")
    fun getAllAsteroid(): LiveData<PictureOfDay>
}