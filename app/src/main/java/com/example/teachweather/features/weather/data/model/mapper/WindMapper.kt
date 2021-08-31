package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.CloudsRes
import com.example.teachweather.features.weather.data.model.CoordRes
import com.example.teachweather.features.weather.data.model.MainRes
import com.example.teachweather.features.weather.data.model.WindRes
import com.example.teachweather.features.weather.domain.model.Clouds
import com.example.teachweather.features.weather.domain.model.Coord
import com.example.teachweather.features.weather.domain.model.Main
import com.example.teachweather.features.weather.domain.model.Wind
import javax.inject.Inject

class WindMapper @Inject constructor() {
    fun map(windRes: WindRes) = Wind(
        deg = windRes.deg,
        speed = windRes.speed
    )
}