package com.example.teachweather.features.location.data.model.mapper

import com.example.teachweather.features.location.data.model.CityRes
import com.example.teachweather.features.location.domain.model.City
import com.example.teachweather.features.location.domain.model.GeoPosition
import javax.inject.Inject

class CityMapper @Inject constructor(
    val geoPositionMapper: GeoPositionMapper
) {
    fun map(cityRes: CityRes) = City(
        geoPosition = cityRes.geoPositionRes.let { geoPositionMapper.map(it) },
        key = cityRes.key
    )
}