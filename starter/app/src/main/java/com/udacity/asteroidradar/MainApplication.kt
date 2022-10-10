package com.udacity.asteroidradar

import android.app.Application
import com.udacity.asteroidradar.data.local.AsteroidDao
import com.udacity.asteroidradar.domain.repository.AsteroidRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}