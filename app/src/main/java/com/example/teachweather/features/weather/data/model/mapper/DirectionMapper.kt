package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.DirectionRes
import com.example.teachweather.features.weather.domain.model.Direction
import javax.inject.Inject

class DirectionMapper @Inject constructor() {
    fun map(res: DirectionRes) = Direction(
        degrees = res.degreesRes,
        english = res.englishRes,
        localized = res.localizedRes
    )
}