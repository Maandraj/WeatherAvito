package com.example.teachweather.features.location.data.model.mapper

import com.example.teachweather.features.location.data.model.CoordLocationRes
import com.example.teachweather.features.location.domain.model.CoordLocation
import javax.inject.Inject

class CoordLocationMapper @Inject constructor() {
    fun map(coordLocation: CoordLocationRes) = CoordLocation(
        lat = coordLocation.lat,
        lon = coordLocation.lon
    )
}