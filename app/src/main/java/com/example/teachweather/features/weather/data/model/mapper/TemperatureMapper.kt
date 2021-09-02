package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.TemperatureRes
import com.example.teachweather.features.weather.domain.model.Temperature
import javax.inject.Inject

class TemperatureMapper  @Inject constructor() {
    fun map(res : TemperatureRes) = Temperature(
        unit = res.unitRes,
        unitType = res.unitTypeRes,
        value = res.valueRes
    )
}