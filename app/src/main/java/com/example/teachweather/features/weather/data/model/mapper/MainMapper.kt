package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.CloudsRes
import com.example.teachweather.features.weather.data.model.CoordRes
import com.example.teachweather.features.weather.data.model.MainRes
import com.example.teachweather.features.weather.domain.model.Clouds
import com.example.teachweather.features.weather.domain.model.Coord
import com.example.teachweather.features.weather.domain.model.Main
import javax.inject.Inject

class MainMapper @Inject constructor() {
    fun map(mainRes: MainRes) = Main(
        feels_like = mainRes.feelsLike,
        humidity = mainRes.humidity,
        pressure = mainRes.pressure,
        temp = mainRes.temp,
        temp_max = mainRes.tempMax,
        temp_min = mainRes.tempMin
    )
}