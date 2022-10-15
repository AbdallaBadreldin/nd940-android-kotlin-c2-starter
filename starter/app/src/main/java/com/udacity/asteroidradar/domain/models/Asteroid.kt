package com.udacity.asteroidradar.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Asteroid(
    /*  @PrimaryKey val id: Long? = 0,
      val element_count: Int? = 0,
      @TypeConverters(Converters::class)
      val links: Links? ,
      @TypeConverters(Converters::class)
      val  near_earth_objects: NearEarthObjects?
  */
/*
//    val codename: String,

    val absoluteMagnitude: Double,
    val estimatedDiameter: Double,
    val isPotentiallyHazardous: Boolean,

    val closeApproachDate: String,

    val relativeVelocity: Double,
    val distanceFromEarth: Double

) : java.io.Serializable*/

    @PrimaryKey(autoGenerate = true) val id: Long,
    val codename: String,
    val closeApproachDate: String,
    val absoluteMagnitude: Double,
    val estimatedDiameter: Double,
    val relativeVelocity: Double,
    val distanceFromEarth: Double,
    val isPotentiallyHazardous: Boolean
) : java.io.Serializable