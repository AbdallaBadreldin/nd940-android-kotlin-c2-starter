package com.udacity.asteroidradar.domain.repository

import com.udacity.asteroidradar.data.local.AsteroidDao
import com.udacity.asteroidradar.data.local.PictureOfTodayDao
import com.udacity.asteroidradar.data.remote.AsteroidResponse
import javax.inject.Inject


class AsteroidRepository @Inject constructor(
   val asteroidDao: AsteroidDao,
    val pictureOfDayDao: PictureOfTodayDao,
    val appNetwork: AsteroidResponse
) {
    fun fetchAllAsteroidDataFromInternet() {
        appNetwork.getAsteroidPhoto()
    }

    fun getAllDataAsteroidFromDatabase() {}

    fun getAsteroidDataFromDatabaseByDate() {}

    fun insertAsteroidDataToDataBase() {}

    fun fetchAllPictureOfTodayDataFromInternet() {}

    fun getAllDataPictureOfTodayFromDatabase() {}

    fun getPictureOfTodayDataFromDatabaseByDate() {}

    fun insertPictureOfTodayDataToDataBase() {}

}