package com.example.teachweather.features.weather.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SnowRes(
    @Json(name = "Unit")
    val unitRes: String,
    @Json(name = "UnitType")
    val unitTypeRes: Int,
    @Json(name = "Value")
    val valueRes: Double
)