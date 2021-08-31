package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.CloudsRes
import com.example.teachweather.features.weather.data.model.CoordRes
import com.example.teachweather.features.weather.data.model.MainRes
import com.example.teachweather.features.weather.data.model.WeatherRes
import com.example.teachweather.features.weather.domain.model.Clouds
import com.example.teachweather.features.weather.domain.model.Coord
import com.example.teachweather.features.weather.domain.model.Main
import com.example.teachweather.features.weather.domain.model.Weather
import javax.inject.Inject

class WeatherMapper @Inject constructor() {
    fun map(weatherRes: WeatherRes) = Weather(
       description =  weatherRes.description,
        icon = weatherRes.icon,
        id = weatherRes.id,
        main = weatherRes.main
    )
}