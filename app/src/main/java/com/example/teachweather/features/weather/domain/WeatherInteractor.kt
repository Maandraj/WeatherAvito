package com.example.teachweather.features.weather.domain

import com.example.teachweather.features.weather.data.WeatherRepo
import java.util.*
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val weatherRepo: WeatherRepo
) {
    suspend fun getWeather12Hours(language: String = Locale.getDefault().language, metric : Boolean = true) = weatherRepo.getWeather12Hours(language, metric)
}