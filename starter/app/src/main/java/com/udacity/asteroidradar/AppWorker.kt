package com.udacity.asteroidradar

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.udacity.asteroidradar.domain.repository.AsteroidRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltWorker
class AppWorker @AssistedInject
constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    @Assisted val repo: AsteroidRepository
) :
    Worker(context, workerParams) {

    override fun doWork(): Result {

        fetchForData()

        return Result.success()
    }

    private fun fetchForData() {
        CoroutineScope(Dispatchers.IO).launch {
            repo.fetchAllAsteroidDataFromInternet()
            repo.fetchAllPictureOfTodayDataFromInternet()
        }
    }
}
