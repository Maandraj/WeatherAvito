package com.example.teachweather.features.weather.data.model.daysRes


import com.example.teachweather.features.weather.data.model.RealFeelTemperatureRes
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class DailyForecastRes(
    @Json(name = "Date")
    val dateRes: String,
    @Json(name = "Day")
    val dayRes: DayRes,
    @Json(name = "EpochDate")
    val epochDateRes: Int,
    @Json(name = "Night")
    val nightRes: NightRes,
    @Json(name = "RealFeelTemperature")
    val realFeelTemperatureRes: RealFeelTemperatureRes,
    @Json(name = "Temperature")
    val temperatureDayRes: TemperatureDayRes
)