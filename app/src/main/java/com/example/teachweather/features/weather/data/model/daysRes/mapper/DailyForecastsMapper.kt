package com.example.teachweather.features.weather.data.model.daysRes.mapper

import com.example.teachweather.features.weather.data.model.daysRes.DailyForecastRes
import com.example.teachweather.features.weather.data.model.mapper.RealFeelTemperatureMapper
import com.example.teachweather.features.weather.domain.model.days.DailyForecast
import javax.inject.Inject

class DailyForecastsMapper @Inject constructor(
    private val realFeelTemperatureMapper: RealFeelTemperatureMapper
    private val temperatureDayMapper: TemperatureDayMapper
) {
    fun map(res: DailyForecastRes) = DailyForecast(
       date = res.dateRes,
        epochDate = res.epochDateRes,
        realFeelTemperature = res.realFeelTemperatureRes.let { realFeelTemperatureMapper.map(it) },
        temperatureDay = res.temperatureDayRes.let { temperatureDayMapper.map(it) }
    )
}