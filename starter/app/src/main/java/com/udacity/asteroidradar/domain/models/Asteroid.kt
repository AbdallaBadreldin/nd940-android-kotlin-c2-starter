package com.udacity.asteroidradar.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Asteroid(
    @PrimaryKey val id: Long? = 0,
    val element_count: Int? = 0,
    val links: Links? ,
    val near_earth_objects: NearEarthObjects?

    /*
//    val codename: String,

    val absoluteMagnitude: Double,
    val estimatedDiameter: Double,
    val isPotentiallyHazardous: Boolean,

    val closeApproachDate: String,

    val relativeVelocity: Double,
    val distanceFromEarth: Double
*/
) : java.io.Serializable