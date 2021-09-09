package com.example.teachweather.features.weather.data.model.daysRes.mapper

import com.example.teachweather.features.weather.data.model.daysRes.DailyForecastRes
import com.example.teachweather.features.weather.data.model.daysRes.WeatherDayRes
import com.example.teachweather.features.weather.data.model.mapper.RealFeelTemperatureMapper
import com.example.teachweather.features.weather.domain.model.days.DailyForecast
import com.example.teachweather.features.weather.domain.model.days.WeatherDay
import javax.inject.Inject

class WeatherDayMapper @Inject constructor(


    private val dailyForecastsMapper: DailyForecastsMapper
) {
    fun map(res: WeatherDayRes) = WeatherDay(
        dailyForecasts = res.dailyForecastsRes.let { res-> res.map { dailyForecastsMapper.map(it) } }
    )
}