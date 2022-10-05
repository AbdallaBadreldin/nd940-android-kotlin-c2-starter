package com.udacity.asteroidradar.di

import com.udacity.asteroidradar.data.local.AsteroidDao
import com.udacity.asteroidradar.data.local.PictureOfTodayDao
import com.udacity.asteroidradar.data.remote.AppNetwork
import com.udacity.asteroidradar.data.remote.AsteroidResponse
import com.udacity.asteroidradar.domain.repository.AsteroidRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAsteroidRepository(
        asteroidDao: AsteroidDao,
        pictureOfDayDao: PictureOfTodayDao,
        appNetwork: AsteroidResponse
    ): AsteroidRepository {
        return AsteroidRepository(
            asteroidDao,
            pictureOfDayDao,
            appNetwork
        )
    }

}