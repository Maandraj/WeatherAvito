package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.WindRes
import com.example.teachweather.features.weather.domain.model.Wind
import javax.inject.Inject

class WindMapper @Inject constructor(
    private val directionMapper: DirectionMapper,
    private val speedMapper: SpeedMapper
) {
    fun map(res: WindRes) = Wind(
        speed = res.speedRes.let { speedMapper.map(it) },
        direction = res.directionRes.let { directionMapper.map(it) }
    )
}