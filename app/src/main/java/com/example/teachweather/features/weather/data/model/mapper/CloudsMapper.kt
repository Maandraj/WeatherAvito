package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.CloudsRes
import com.example.teachweather.features.weather.domain.model.Clouds
import javax.inject.Inject

class CloudsMapper @Inject constructor() {
    fun map(cloudsRes: CloudsRes) = Clouds(all = cloudsRes.all)
}