package com.udacity.asteroidradar.data.remote

import com.udacity.asteroidradar.Constants
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor: Interceptor  {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder().header(
            "Accept", "application/json"
        ).header("api_key",Constants.API_KEY).build()
        return chain.proceed(request)
    }
}