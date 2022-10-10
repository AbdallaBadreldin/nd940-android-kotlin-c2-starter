package com.udacity.asteroidradar.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.udacity.asteroidradar.data.local.Converters

@Entity
data class Asteroid(
    @PrimaryKey val id: Long? = 0,
    val element_count: Int? = 0,
    @TypeConverters(Converters::class)
    val links: Links? ,
    @TypeConverters(Converters::class)
    val  near_earth_objects: NearEarthObjects?

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