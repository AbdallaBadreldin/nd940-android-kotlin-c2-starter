package com.udacity.asteroidradar.data.remote

import com.udacity.asteroidradar.Constants.API_KEY
import com.udacity.asteroidradar.domain.models.Asteroid
import com.udacity.asteroidradar.domain.models.PictureOfDay
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AsteroidResponse {
    @GET("planetary/apod?api_key=${API_KEY}")
    suspend fun getAsteroidPhoto(): Response<PictureOfDay?>?

    @GET("neo/rest/v1/feed?start_date={start_date}&end_date={end_date}&api_key=$API_KEY")
    suspend fun getAsteroidList(
        @Path("start_date") startDate: String,
        @Path("end_date") endDate: String
    ): Response<Asteroid?>?

}