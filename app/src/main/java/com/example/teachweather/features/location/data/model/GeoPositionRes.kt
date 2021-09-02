package com.example.teachweather.features.location.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GeoPositionRes(
    @Json(name = "Latitude")
    val latitude: Double,
    @Json(name = "Longitude")
    val longitude: Double
)