package com.example.teachweather.features.location.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoordLocationRes(
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lon")
    val lon: Double
)