package com.udacity.asteroidradar.domain.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.udacity.asteroidradar.api.parseAsteroidsJsonResult
import com.udacity.asteroidradar.data.local.AsteroidDao
import com.udacity.asteroidradar.data.local.PictureOfTodayDao
import com.udacity.asteroidradar.data.remote.AsteroidResponse
import com.udacity.asteroidradar.domain.models.Asteroid
import com.udacity.asteroidradar.domain.models.PictureOfDay
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class AsteroidRepository @Inject constructor(
    private val asteroidDao: AsteroidDao,
    private val pictureOfDayDao: PictureOfTodayDao,
    private val appNetwork: AsteroidResponse
) {
    fun fetchAllAsteroidDataFromInternet() {
        CoroutineScope(Dispatchers.IO).launch {
            runBlocking {
                val call: Call<String> = appNetwork.getAsteroidList()
                call.enqueue(object : Callback<String> {
                    override fun onResponse(
                        call: Call<String>,
                        response: Response<String>
                    ) {
                        if (response.isSuccessful) {
                            val arrray =
                                parseAsteroidsJsonResult(JSONObject(response.body().toString()))
                            insertAsteroidDataToDataBase(arrray)

                        }
                    }

                    override fun onFailure(call: Call<String>, t: Throwable) {
//                        Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT)
//                            .show() // ALL NETWORK ERROR HERE
                    }
                })

            }
        }
    }

    fun getAllDataAsteroidFromDatabase(): LiveData<List<Asteroid>> {
        return asteroidDao.getAllAsteroid()
    }

    fun getAsteroidDataFromDatabaseForToday(): LiveData<List<Asteroid>> {
        val currentDate = Calendar.getInstance().time
        val df = SimpleDateFormat("yyyy-MM-dd", Locale("en"))
        val day = df.format(currentDate)
        return asteroidDao.getAsteroidForToday(day)
    }

    fun getAsteroidDataFromDatabaseForNextWeek(): LiveData<List<Asteroid>> {
        val currentDate = Calendar.getInstance().time
        val df = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())
        val day = df.format(currentDate)
        return asteroidDao.getAsteroidForToday(day)
    }

    private fun insertAsteroidDataToDataBase(body: ArrayList<Asteroid>?) {
        CoroutineScope(Dispatchers.IO).launch {
            asteroidDao.insertAsteroid(body!!)
        }
    }

    fun fetchAllPictureOfTodayDataFromInternet() {
        CoroutineScope(Dispatchers.IO).launch {
            runBlocking {
                val pic = appNetwork.getAsteroidPhoto()
                if (pic!!.isSuccessful) {
                    insertPictureOfTodayDataToDataBase(pic.body())
                } else {
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