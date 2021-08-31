package com.example.teachweather.features.weather.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoordRes(
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lon")
    val lon: Double
)