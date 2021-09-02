package com.example.teachweather.features.weather.data

import com.example.teachweather.features.weather.data.api.WeatherApi
import com.example.teachweather.features.weather.data.model.mapper.WeatherMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepo @Inject constructor(
    private val api: WeatherApi,
    private val weatherMapper: WeatherMapper
) {
    suspend fun getWeather12Hours(language: String, metric: Boolean = true) = withContext(Dispatchers.IO) {
        api.getForecast12hours(language = language, metric = metric)
            .let { res -> res.map { weatherMapper.map(it) } }
    }

}