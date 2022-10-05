package com.udacity.asteroidradar.data.remote

import com.udacity.asteroidradar.Constants.API_KEY
import com.udacity.asteroidradar.domain.models.Asteroid
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AsteroidResponse {
    @GET("planetary/apod?api_key=$API_KEY")
    fun getAsteroidPhoto(): Response<Asteroid>

    @GET("neo/rest/v1/feed?start_date={start_date}&end_date={end_date}&api_key=$API_KEY")
    fun getAsteroidList(@Path("start_date")startDate:String,
                             @Path("end_date") endDate:String): Callback<Asteroid>
}