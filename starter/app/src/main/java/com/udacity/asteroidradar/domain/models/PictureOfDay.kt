package com.udacity.asteroidradar.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class PictureOfDay(@SerializedName( "media_type") @PrimaryKey val mediaType: String, val title: String?,
                        val url: String?): Serializable