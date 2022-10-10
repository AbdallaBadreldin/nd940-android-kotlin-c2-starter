package com.udacity.asteroidradar.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.*
import com.udacity.asteroidradar.domain.models.PictureOfDay

@Dao
interface PictureOfTodayDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsteroid(picOfToday: PictureOfDay)

//    @Query("Select * From PictureOfDay")
//    fun getAllAsteroid(): LiveData<PictureOfDay>
//
//    @Query("DELETE FROM PictureOfDay")
//    fun clearAllData()

}