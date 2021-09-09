package com.example.teachweather.features.weather.domain

import com.example.teachweather.features.weather.data.WeatherRepo
import com.example.teachweather.utils.WeatherCredentials
import java.util.*
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val weatherRepo: WeatherRepo
) {
    suspend fun getWeather12Hours(
        language: String = Locale.getDefault().language,
        metric: Boolean = WeatherCredentials.metric
    ) = weatherRepo.getWeatherTwelveHours(language, metric)
    suspend fun getWeatherWeekHours(
        language: String = Locale.getDefault().language,
        metric: Boolean = WeatherCredentials.metric
    ) = weatherRepo.getWeatherWeekDays(language, metric)
}