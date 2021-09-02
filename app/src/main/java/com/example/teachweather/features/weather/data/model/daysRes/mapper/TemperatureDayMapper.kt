package com.example.teachweather.features.weather.data.model.daysRes.mapper

import com.example.teachweather.features.weather.data.model.TemperatureRes
import com.example.teachweather.features.weather.data.model.daysRes.TemperatureDayRes
import com.example.teachweather.features.weather.domain.model.Temperature
import com.example.teachweather.features.weather.domain.model.days.TemperatureDay
import javax.inject.Inject

class TemperatureDayMapper @Inject constructor(
    private val temperatureMinMaxMapper: TemperatureMinMaxMapper
) {
        fun map(res : TemperatureDayRes) = TemperatureDay(
            maximum = res.maximumRes.let {  temperatureMinMaxMapper.mapMax(it)},
            minimum = res.minimumRes.let {  temperatureMinMaxMapper.mapMin(it)}
        )
}