package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.RainRes
import com.example.teachweather.features.weather.domain.model.Rain
import javax.inject.Inject

class RainMapper  @Inject constructor() {
    fun map(res : RainRes) = Rain(
        unit =  res.unitRes,
        unitType = res.unitTypeRes,
        value = res.valueRes
    )
}