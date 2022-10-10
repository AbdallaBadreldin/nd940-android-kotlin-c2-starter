package com.udacity.asteroidradar.di

import com.google.gson.GsonBuilder
import com.udacity.asteroidradar.data.remote.ApiKeyInterceptor
import com.udacity.asteroidradar.data.remote.AsteroidResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val baseUrl = "https://api.nasa.gov/"

    @Singleton
    @Provides
    fun provideNetworkService(): AsteroidResponse {

//        val httpClient = OkHttpClient.Builder()
//            .addInterceptor(ApiKeyInterceptor())

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
//            .client(httpClient.build())
            .baseUrl(baseUrl)
//            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
            .create(AsteroidResponse::class.java)
    }

}
