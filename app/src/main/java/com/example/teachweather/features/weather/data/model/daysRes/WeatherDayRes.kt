package com.example.teachweather.features.weather.data.model.daysRes


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class WeatherDayRes(
    @Json(name = "DailyForecasts")
    val dailyForecastsRes: List<DailyForecastRes>,
    @Json(name = "Headline")
    val headlineRes: HeadlineRes
)