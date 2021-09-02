package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.RealFeelTemperatureRes
import com.example.teachweather.features.weather.domain.model.RealFeelTemperature
import javax.inject.Inject

class RealFeelTemperatureMapper  @Inject constructor() {
    fun map(res : RealFeelTemperatureRes) = RealFeelTemperature(
        unit =  res.unitRes,
        unitType = res.unitTypeRes,
        value = res.valueRes
    )
}