package com.udacity.asteroidradar.domain.models

data class NearEarthObjects(
    val dates: List<Map<String, DateOFObjects?>?>?
)

data class DateOFObjects(val ids: List<Map<String, List<Dates?>?>?>?)

