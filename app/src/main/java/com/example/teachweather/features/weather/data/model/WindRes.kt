package com.example.teachweather.features.weather.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WindRes(
    @Json(name = "Direction")
    val directionRes: DirectionRes,
    @Json(name = "Speed")
    val speedRes: SpeedRes
)