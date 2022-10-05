package com.udacity.asteroidradar.ui.main

import androidx.lifecycle.ViewModel
import com.udacity.asteroidradar.domain.repository.AsteroidRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(repo: AsteroidRepository) : ViewModel() {

    fun getAllPicturesOfToday(){
        repo.
    }
}