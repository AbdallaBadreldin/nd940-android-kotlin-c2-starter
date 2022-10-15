package com.udacity.asteroidradar.domain.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory
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
import javax.inject.Inject


class AsteroidRepository @Inject constructor(
    private val asteroidDao: AsteroidDao,
    private val pictureOfDayDao: PictureOfTodayDao,
    private val appNetwork: AsteroidResponse
) {
    fun fetchAllAsteroidDataFromInternet() {
        CoroutineScope(Dispatchers.IO).launch {
            runBlocking {
                val respon = appNetwork.getAsteroidList()
                val call: Call<String> = appNetwork.getAsteroidList()
                call.enqueue(object : Callback<String> {
                    override fun onResponse(
                        call: Call<String>,
                        response: Response<String>
                    ) {
                        if (response.isSuccessful) {
                         val arrray=   parseAsteroidsJsonResult( JSONObject(response.body().toString()))
                            insertAsteroidDataToDataBase(arrray)
                            Log.v("TAG RESPONSE",response.body().toString())

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

    fun getAsteroidDataFromDatabaseByDate() {}

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
                    Log.v("TAG", pic.message())
                    Log.v("TAG", pic.errorBody().toString())
                    Log.v("TAG", pic.toString())
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