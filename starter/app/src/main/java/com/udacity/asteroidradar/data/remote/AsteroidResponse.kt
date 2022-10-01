package com.udacity.asteroidradar.data.remote

import com.udacity.asteroidradar.Constants.API_KEY
import com.udacity.asteroidradar.domain.models.Asteroid
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface AsteroidResponse {
    @GET("planetary/apod?api_key=$API_KEY")
    fun getAsteroidPhotoAsync(): Deferred<Asteroid>

    @GET("neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=$API_KEY")
    fun getAsteroidListAsync(): Deferred<Asteroid>
}