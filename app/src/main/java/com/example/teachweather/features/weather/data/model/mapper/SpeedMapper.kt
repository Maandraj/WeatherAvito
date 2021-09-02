package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.SpeedRes
import com.example.teachweather.features.weather.domain.model.Speed
import javax.inject.Inject

class SpeedMapper @Inject constructor() {
    fun map(res: SpeedRes) = Speed(
        unit = res.unitRes,
        unitType = res.unitTypeRes,
        value = res.valueRes
    )
}