package com.udacity.asteroidradar.ui.main

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.udacity.asteroidradar.domain.models.Asteroid
import com.udacity.asteroidradar.domain.models.PictureOfDay
import com.udacity.asteroidradar.domain.repository.AsteroidRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repo: AsteroidRepository) : ViewModel() {

    fun getAllPicturesOfToday(): LiveData<PictureOfDay> {
        return repo.getAllDataPictureOfTodayFromDatabase()
    }

    fun getAllAsteroids(): LiveData<List<Asteroid>> {
        return repo.getAllDataAsteroidFromDatabase()
    }

    fun getTodayAsteroidData(): LiveData<List<Asteroid>> {
        return repo.getAsteroidDataFromDatabaseForToday()
    }

    fun fetchAllAsteroids() {
        repo.fetchAllAsteroidDataFromInternet()
    }

    fun fetchAllPicturesOfToday() {
        repo.fetchAllPictureOfTodayDataFromInternet()
    }

    fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }
}