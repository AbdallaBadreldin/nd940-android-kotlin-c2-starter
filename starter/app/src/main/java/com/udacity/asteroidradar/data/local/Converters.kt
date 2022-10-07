package com.udacity.asteroidradar.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.udacity.asteroidradar.domain.models.*
import java.util.*


class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    @TypeConverter
    fun stringToDate(value: String?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToString(date: Date?): String? {
        return date?.time?.toString()
    }

    @TypeConverter
    fun objectToJson(value: Any?) = Gson().toJson(value)

    @TypeConverter
    fun stringToNearEarthObject(string: String?): NearEarthObjects? {
        return Gson().fromJson(string, NearEarthObjects::class.java)
    }

    @TypeConverter
    fun stringToAsteroid(string: String?): Asteroid? {
        return Gson().fromJson(string, Asteroid::class.java)
    }

    @TypeConverter
    fun stringToCloseApproachData(string: String?): CloseApproachData? {
        return Gson().fromJson(string, CloseApproachData::class.java)
    }

    @TypeConverter
    fun stringToDates(string: String?): Dates? {
        return Gson().fromJson(string, Dates::class.java)
    }

    @TypeConverter
    fun stringToEstimatedDiameter(string: String?): EstimatedDiameter? {
        return Gson().fromJson(string, EstimatedDiameter::class.java)
    }

    @TypeConverter
    fun stringToFeet(string: String?): Feet? {
        return Gson().fromJson(string, Feet::class.java)
    }

    @TypeConverter
    fun stringToKilometers(string: String?): Kilometers? {
        return Gson().fromJson(string, Kilometers::class.java)
    }

    @TypeConverter
    fun stringToLinks(string: String?): Links? {
        return Gson().fromJson(string, Links::class.java)
    }

    @TypeConverter
    fun stringToMeters(string: String?): Meters? {
        return Gson().fromJson(string, Meters::class.java)
    }

    @TypeConverter
    fun stringToMiles(string: String?): Miles? {
        return Gson().fromJson(string, Miles::class.java)
    }

    @TypeConverter
    fun stringToMissDistance(string: String?): MissDistance? {
        return Gson().fromJson(string, MissDistance::class.java)
    }

    @TypeConverter
    fun stringToPictureOfToday(string: String?): PictureOfDay? {
        return Gson().fromJson(string, PictureOfDay::class.java)
    }

    @TypeConverter
    fun stringToRelativeVelocity(string: String?): RelativeVelocity? {
        return Gson().fromJson(string, RelativeVelocity::class.java)
    }

//    @TypeConverter
//    fun stringToNearEarthObject(string: String?): NearEarthObjects? {
//        return Gson().fromJson(string, NearEarthObjects::class.java)
//    }

}