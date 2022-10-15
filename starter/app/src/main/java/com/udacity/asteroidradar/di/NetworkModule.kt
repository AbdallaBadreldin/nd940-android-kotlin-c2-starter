package com.udacity.asteroidradar.di

import com.google.gson.GsonBuilder
import com.udacity.asteroidradar.data.remote.ApiKeyInterceptor
import com.udacity.asteroidradar.data.remote.AsteroidResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val baseUrl = "https://api.nasa.gov/"

    @Singleton
    @Provides
    fun provideNetworkService(): AsteroidResponse {

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor())

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .client(httpClient.build())
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(AsteroidResponse::class.java)
    }

}
