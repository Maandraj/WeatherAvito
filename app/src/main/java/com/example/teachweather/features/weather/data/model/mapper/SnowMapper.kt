package com.example.teachweather.features.weather.data.model.mapper


import com.example.teachweather.features.weather.data.model.SnowRes

import com.example.teachweather.features.weather.domain.model.Snow
import javax.inject.Inject

class SnowMapper  @Inject constructor() {
    fun map(res : SnowRes) = Snow(
        unit =  res.unitRes,
        unitType = res.unitTypeRes,
        value = res.valueRes
    )
}