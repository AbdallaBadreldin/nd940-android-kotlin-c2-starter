package com.udacity.asteroidradar.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.asteroidradar.domain.models.Asteroid

@Dao
interface AsteroidDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAsteroid(astroid: Asteroid)

//    @Query("Select * From Asteroid")
//    fun getAllAsteroid(): LiveData<List<Asteroid>>
//
//    @Query("DELETE FROM Asteroid")
//    fun clearAllData()
}