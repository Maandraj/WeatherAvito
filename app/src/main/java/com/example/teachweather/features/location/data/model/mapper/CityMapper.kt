package com.example.teachweather.features.location.data.model.mapper

import com.example.teachweather.features.location.data.model.CityRes
import com.example.teachweather.features.location.domain.model.City
import javax.inject.Inject

class CityMapper @Inject constructor(
    private val coordLocationMapper: CoordLocationMapper
) {
    fun map(cityRes: CityRes) = City(
        country = cityRes.country,
        name = cityRes.name,
        id = cityRes.id,
        state = cityRes.state,
        coordLocation = cityRes.coordLocationRes.let { coordLocationMapper.map(it) }
    )
}