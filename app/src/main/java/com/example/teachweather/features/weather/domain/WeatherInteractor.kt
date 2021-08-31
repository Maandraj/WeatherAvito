package com.example.teachweather.features.weather.domain

import com.example.teachweather.features.weather.data.WeatherRepo
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val weatherRepo: WeatherRepo
) {
    suspend fun getWeather(city: String) = weatherRepo.getWeather(city)
}