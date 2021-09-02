package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.IceRes
import com.example.teachweather.features.weather.domain.model.Ice
import javax.inject.Inject

class IceMapper @Inject constructor() {
    fun map(res: IceRes) = Ice(
        unit = res.unitRes,
        unitType = res.unitTypeRes,
        value = res.valueRes
    )
}