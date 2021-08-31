package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.CloudsRes
import com.example.teachweather.features.weather.data.model.CoordRes
import com.example.teachweather.features.weather.domain.model.Clouds
import com.example.teachweather.features.weather.domain.model.Coord
import javax.inject.Inject

class CoordMapper @Inject constructor() {
    fun map(coordRes: CoordRes) = Coord(
        lat = coordRes.lat,
        lon = coordRes.lon)
}