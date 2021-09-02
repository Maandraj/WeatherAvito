package com.example.teachweather.features.location.data.model.mapper

import com.example.teachweather.features.location.data.model.GeoPositionRes
import com.example.teachweather.features.location.domain.model.GeoPosition
import javax.inject.Inject

class GeoPositionMapper @Inject constructor() {
    fun map(geoPositionRes: GeoPositionRes) = GeoPosition(
            latitude = geoPositionRes.latitude,
            longitude = geoPositionRes.longitude)
}