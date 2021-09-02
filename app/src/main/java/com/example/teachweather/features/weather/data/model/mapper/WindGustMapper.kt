package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.WindGustRes
import com.example.teachweather.features.weather.domain.model.WindGust
import javax.inject.Inject

class WindGustMapper @Inject constructor(
    private val speedMapper: SpeedMapper
) {
    fun map(res: WindGustRes) = WindGust(
        speed = res.speedRes.let { speedMapper.map(it) }
    )
}