package com.udacity.asteroidradar.data.remote

import com.udacity.asteroidradar.Constants.API_KEY
import com.udacity.asteroidradar.domain.models.PictureOfDay
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface AsteroidResponse {
    @GET("planetary/apod?api_key=${API_KEY}")
    suspend fun getAsteroidPhoto(): Response<PictureOfDay?>?

    //neo/rest/v1/feed?api_key=3ad1TDh6cFdJPxeb33BGWz9hpksOdBNHaO6kJCQj
    @GET("neo/rest/v1/feed?api_key=$API_KEY")
    fun getAsteroidList(
    ): Call<String>

}