package com.example.teachweather.features.weather.domain.model.days

import com.example.teachweather.features.weather.domain.model.RealFeelTemperature

data class DailyForecast(
    val date: String,
    val day: Day,
    val epochDate: Int,
    val night: Night,
    val realFeelTemperature: RealFeelTemperature,
    val temperatureDay: TemperatureDay
)