package com.example.teachweather.features.weather.data.model.daysRes


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TemperatureDayRes(
    @Json(name = "Maximum")
    val maximumRes: MaximumRes,
    @Json(name = "Minimum")
    val minimumRes: MinimumRes
)