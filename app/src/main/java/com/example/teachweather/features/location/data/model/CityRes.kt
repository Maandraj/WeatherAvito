package com.example.teachweather.features.location.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CityRes(
    @Json(name = "coord")
    val coordLocationRes: CoordLocationRes,
    @Json(name = "country")
    val country: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "state")
    val state: String
)