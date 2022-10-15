package com.udacity.asteroidradar.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.asteroidradar.domain.models.Asteroid
import retrofit2.http.Path

@Dao
interface AsteroidDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsteroid(asteroid: ArrayList<Asteroid>)

    @Query("Select * From Asteroid")
    fun getAllAsteroid(): LiveData<List<Asteroid>>

    @Query("DELETE FROM Asteroid")
    fun clearAllData()

    @Query("Select * From Asteroid Where closeApproachDate LIKE :day")
    fun getAsteroidForToday(day:String): LiveData<List<Asteroid>>
}