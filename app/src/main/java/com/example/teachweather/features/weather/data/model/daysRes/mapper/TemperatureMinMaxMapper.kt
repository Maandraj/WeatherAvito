package com.example.teachweather.features.weather.data.model.daysRes.mapper

import com.example.teachweather.features.weather.data.model.TemperatureRes
import com.example.teachweather.features.weather.data.model.daysRes.MaximumRes
import com.example.teachweather.features.weather.data.model.daysRes.MinimumRes
import com.example.teachweather.features.weather.domain.model.Temperature
import com.example.teachweather.features.weather.domain.model.days.Maximum
import com.example.teachweather.features.weather.domain.model.days.Minimum
import javax.inject.Inject

class TemperatureMinMaxMapper  @Inject constructor() {
    fun mapMax(res : MaximumRes) = Maximum(
        unit = res.unitRes,
        unitType = res.unitTypeRes,
        value = res.valueRes
    )
    fun mapMin(res : MinimumRes) = Minimum(
        unit = res.unitRes,
        unitType = res.unitTypeRes,
        value = res.valueRes
    )
}