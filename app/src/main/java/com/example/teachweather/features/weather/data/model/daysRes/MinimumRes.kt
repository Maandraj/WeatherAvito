package com.example.teachweather.features.weather.data.model.daysRes


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MinimumRes(
    @Json(name = "Unit")
    val unitRes: String,
    @Json(name = "UnitType")
    val unitTypeRes: Int,
    @Json(name = "Value")
    val valueRes: Double
)