package com.udacity.asteroidradar.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.udacity.asteroidradar.domain.models.PictureOfDay
import com.udacity.asteroidradar.domain.repository.AsteroidRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repo: AsteroidRepository) : ViewModel() {

    fun getAllPicturesOfToday(): LiveData<PictureOfDay> {
        return repo.getAllDataPictureOfTodayFromDatabase()
    }

    fun fetchAllPicturesOfToday() {
        repo.fetchAllPictureOfTodayDataFromInternet()
    }


}