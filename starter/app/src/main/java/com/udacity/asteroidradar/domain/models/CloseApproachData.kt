package com.udacity.asteroidradar.domain.models

data class CloseApproachData(
    val close_approach_date: String? = null,
    val close_approach_date_full: String? = null,
    val epoch_date_close_approach: Long?,
    val miss_distance: MissDistance?,
    val orbiting_body: String?,
    val relative_velocity: RelativeVelocity?
)
/*
data class CloseApproachDataX(
    val close_approach_date: String,
    val close_approach_date_full: String,
    val epoch_date_close_approach: Long,
    val miss_distance: MissDistanceX,
    val orbiting_body: String,
    val relative_velocity: RelativeVelocityX
)
*/