package com.udacity.asteroidradar.domain.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.udacity.asteroidradar.data.local.AsteroidDao
import com.udacity.asteroidradar.data.local.PictureOfTodayDao
import com.udacity.asteroidradar.data.remote.AsteroidResponse
import com.udacity.asteroidradar.domain.models.Asteroid
import com.udacity.asteroidradar.domain.models.PictureOfDay
import kotlinx.coroutines.*
import retrofit2.Response
import javax.inject.Inject


class AsteroidRepository @Inject constructor(
    private val asteroidDao: AsteroidDao,
    private val pictureOfDayDao: PictureOfTodayDao,
    private val appNetwork: AsteroidResponse
) {
//    suspend fun fetchAllAsteroidDataFromInternet(): Response<Asteroid?>? {
//        return CoroutineScope(Dispatchers.IO).async {
//            return@async appNetwork.getAsteroidList()
//        }.await()
//    }

    suspend fun getAllDataAsteroidFromDatabase(): LiveData<List<Asteroid>> {
        return CoroutineScope(Dispatchers.IO).async {
            return@async asteroidDao.getAllAsteroid()
        }.await()
    }

    fun getAsteroidDataFromDatabaseByDate() {}

    fun insertAsteroidDataToDataBase() {}

    fun fetchAllPictureOfTodayDataFromInternet() {
        CoroutineScope(Dispatchers.IO).launch {
            runBlocking {
            val pic = appNetwork.getAsteroidPhoto()
            if (pic!!.isSuccessful) {
                insertPictureOfTodayDataToDataBase(pic.body())
            }
            else{
                Log.v("TAG",pic.message())
                Log.v("TAG",pic.errorBody().toString())
                Log.v("TAG",pic.toString())

            }
            }
        }
    }

    fun getAllDataPictureOfTodayFromDatabase(): LiveData<PictureOfDay> {
        return pictureOfDayDao.getAllAsteroid()

    }

    private suspend fun insertPictureOfTodayDataToDataBase(picOfToday: PictureOfDay?) {
            pictureOfDayDao.insertAsteroid(picOfToday = picOfToday!!)
    }

    fun clearAllPicturesOfTodayData() {
        pictureOfDayDao.clearAllData()
    }

    fun clearAllAsteroidData() {
        asteroidDao.clearAllData()

    }
}