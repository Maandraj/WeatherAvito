package com.example.teachweather.features.weather.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WindGustRes(
    @Json(name = "Speed")
    val speedRes: SpeedRes
)