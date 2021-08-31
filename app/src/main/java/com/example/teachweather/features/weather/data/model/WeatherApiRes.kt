package com.example.teachweather.features.weather.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherApiRes(
    @Json(name = "base")
    val base: String,
    @Json(name = "clouds")
    val cloudsRes: CloudsRes,
    @Json(name = "cod")
    val cod: Int,
    @Json(name = "coord")
    val coordRes: CoordRes,
    @Json(name = "dt")
    val dt: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "main")
    val mainRes: MainRes,
    @Json(name = "name")
    val name: String,
    @Json(name = "sys")
    val sysRes: SysRes,
    @Json(name = "timezone")
    val timezone: Int,
    @Json(name = "visibility")
    val visibility: Int,
    @Json(name = "weather")
    val weatherRes: List<WeatherRes>,
    @Json(name = "wind")
    val windRes: WindRes
)