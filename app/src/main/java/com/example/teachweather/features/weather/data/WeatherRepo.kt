package com.example.teachweather.features.weather.data

import com.example.teachweather.features.weather.data.api.WeatherApi
import com.example.teachweather.features.weather.data.model.mapper.WeatherDomainMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepo @Inject constructor(
    private val api: WeatherApi,
    private val weatherDomainMapper: WeatherDomainMapper
) {
    suspend fun getWeather(city: String) = withContext(Dispatchers.IO) {
        api.getCityWeather(city).let { weatherDomainMapper.map(it) }
    }

}