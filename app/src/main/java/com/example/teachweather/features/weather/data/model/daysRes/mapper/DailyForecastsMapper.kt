package com.example.teachweather.features.weather.data.model.daysRes.mapper

import com.example.teachweather.features.weather.data.model.daysRes.DailyForecastRes
import com.example.teachweather.features.weather.data.model.mapper.RealFeelTemperatureMapper
import com.example.teachweather.features.weather.domain.model.days.DailyForecast
import javax.inject.Inject

class DailyForecastsMapper @Inject constructor(

    private val realFeelTemperatureMapper: RealFeelTemperatureMapper,
    private val dayMapper: DayMapper,
    private val nightMapper: NightMapper,
    private val temperatureDayMapper: TemperatureDayMapper
) {
    fun map(res: DailyForecastRes) = DailyForecast(
        date = res.dateRes,
        epochDate = res.epochDateRes,
        realFeelTemperature = res.realFeelTemperatureRes.let { realFeelTemperatureMapper.map(it) },
        temperatureDay = res.temperatureDayRes.let { temperatureDayMapper.map(it) },
        day = res.dayRes.let { dayMapper.map(it) },
        night = res.nightRes.let { nightMapper.map(it) }
    )
}