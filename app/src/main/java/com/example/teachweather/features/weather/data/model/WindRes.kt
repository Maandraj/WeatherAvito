package com.example.teachweather.features.weather.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WindRes(
    @Json(name = "deg")
    val deg: Int,
    @Json(name = "speed")
    val speed: Double
)