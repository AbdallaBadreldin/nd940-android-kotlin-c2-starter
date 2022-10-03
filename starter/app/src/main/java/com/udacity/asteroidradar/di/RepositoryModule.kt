package com.udacity.asteroidradar.di

import com.udacity.asteroidradar.data.local.AsteroidDao
import com.udacity.asteroidradar.data.local.PictureOfTodayDao
import com.udacity.asteroidradar.data.remote.AppNetwork
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
        appNetwork: AppNetwork
    ): AsteroidRepository {
        return AsteroidRepository(
            asteroidDao,
            pictureOfDayDao,
            appNetwork
        )
    }

//    @Singleton
//    @Provides
//    fun provideViewsRepository(
//         adsViewsDao: AdsViewsDao,
//        viewsServices: NetworkServices
//    ): ViewsRepository {
//        return ViewsRepository(adsViewsDao,viewsServices)
//    }
//
//    @Singleton
//    @Provides
//    fun provideAdsRepository(
//        adDao: DownloadedItems,
//        videoDao: StoredVideos,
//        networkServices: NetworkServices
//    ): AdsRepository {
//        return AdsRepository(
//            adDao,
//            videoDao,
//            networkServices
//        )
//    }
//
//    @Singleton
//    @Provides
//    fun provideVendorRepository(networkServices: NetworkServices): BrandsRepository {
//        return BrandsRepository(networkServices)
//    }
//
//    @Singleton
//    @Provides
//    fun provideVendorProductsRepository(networkServices: NetworkServices): ProductVendorRepository {
//        return ProductVendorRepository(networkServices)
//    }
//
//    @Singleton
//    @Provides
//    fun provideUserRepository(
//        networkServices: NetworkServices,
//        userSharedPreferences: UserSharedPreferences,
//    ): UserRepository {
//        return UserRepository(networkServices, userSharedPreferences)
//    }
//
//    @Singleton
//    @Provides
//    fun provideOrdersRepository(networkServices: NetworkServices): OrdersRepository {
//        return OrdersRepository(networkServices)
//    }
//
//    @Singleton
//    @Provides
//    fun provideDiscountRepository(networkServices: NetworkServices): DiscountRepository {
//        return DiscountRepository(networkServices)
//    }
//
//    @Singleton
//    @Provides
//    fun provideDraftOrderRepository(networkServices: NetworkServices) : DraftOrderRepository {
//        return DraftOrderRepository(networkServices)
//    }
}