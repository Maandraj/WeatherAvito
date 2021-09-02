package com.example.teachweather.features.weather.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DirectionRes(
    @Json(name = "Degrees")
    val degreesRes: Int,
    @Json(name = "English")
    val englishRes: String,
    @Json(name = "Localized")
    val localizedRes: String
)