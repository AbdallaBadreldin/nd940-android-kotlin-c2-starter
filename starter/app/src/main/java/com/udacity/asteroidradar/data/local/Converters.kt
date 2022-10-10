package com.udacity.asteroidradar.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.udacity.asteroidradar.domain.models.*
import java.util.*

@ProvidedTypeConverter
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

//    @TypeConverter
//    fun objectToJson(value: Any?) = Gson().toJson(value)

    @TypeConverter
    fun stringToNearEarthObject(string: String?): NearEarthObjects? {
        return Gson().fromJson(string, NearEarthObjects::class.java)
    }
    @TypeConverter
    fun nearEarthObjectsToJson(value: NearEarthObjects?) = Gson().toJson(value)


    @TypeConverter
    fun stringToAsteroid(string: String?): Asteroid? {
        return Gson().fromJson(string, Asteroid::class.java)
    }
    @TypeConverter
    fun asteroidToJson(value: Asteroid?) = Gson().toJson(value)


    @TypeConverter
    fun stringToCloseApproachData(string: String?): CloseApproachData? {
        return Gson().fromJson(string, CloseApproachData::class.java)
    }
    @TypeConverter
    fun closeApproachDataToJson(value: CloseApproachData?) = Gson().toJson(value)




    @TypeConverter
    fun stringToEstimatedDiameter(string: String?): EstimatedDiameter? {
        return Gson().fromJson(string, EstimatedDiameter::class.java)
    }
    @TypeConverter
    fun estimatedDiameterToJson(value: EstimatedDiameter?) = Gson().toJson(value)


    @TypeConverter
    fun stringToFeet(string: String?): Feet? {
        return Gson().fromJson(string, Feet::class.java)
    }
    @TypeConverter
    fun feetToJson(value: Feet?) = Gson().toJson(value)


    @TypeConverter
    fun stringToKilometers(string: String?): Kilometers? {
        return Gson().fromJson(string, Kilometers::class.java)
    }
    @TypeConverter
    fun kilometersToJson(value: Kilometers?) = Gson().toJson(value)


    @TypeConverter
    fun stringToLinks(string: String?): Links? {
        return Gson().fromJson(string, Links::class.java)
    }
    @TypeConverter
    fun linksToJson(value: Links?) = Gson().toJson(value)


    @TypeConverter
    fun stringToMeters(string: String?): Meters? {
        return Gson().fromJson(string, Meters::class.java)
    }
    @TypeConverter
    fun metersToJson(value: Meters?) = Gson().toJson(value)


    @TypeConverter
    fun stringToMiles(string: String?): Miles? {
        return Gson().fromJson(string, Miles::class.java)
    }
    @TypeConverter
    fun milesToJson(value: Miles?) = Gson().toJson(value)



    @TypeConverter
    fun stringToMissDistance(string: String?): MissDistance? {
        return Gson().fromJson(string, MissDistance::class.java)
    }
    @TypeConverter
    fun MissDistanceToJson(value: MissDistance?) = Gson().toJson(value)



    @TypeConverter
    fun stringToPictureOfToday(string: String?): PictureOfDay? {
        return Gson().fromJson(string, PictureOfDay::class.java)
    }
    @TypeConverter
    fun pictureOfDayToJson(value: PictureOfDay?) = Gson().toJson(value)


    @TypeConverter
    fun stringToRelativeVelocity(string: String?): RelativeVelocity? {
        return Gson().fromJson(string, RelativeVelocity::class.java)
    }
    @TypeConverter
    fun relativeVelocityToJson(value: RelativeVelocity?) = Gson().toJson(value)


//    @TypeConverter
//    fun stringToNearEarthObject(string: String?): NearEarthObjects? {
//        return Gson().fromJson(string, NearEarthObjects::class.java)
//    }

}