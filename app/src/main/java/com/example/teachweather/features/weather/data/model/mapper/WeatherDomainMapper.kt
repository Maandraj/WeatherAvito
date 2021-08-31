package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.WeatherApiRes
import com.example.teachweather.features.weather.domain.model.WeatherDomain
import javax.inject.Inject

class WeatherDomainMapper @Inject constructor(
    private val cloudsMapper: CloudsMapper,
    private val coordMapper: CoordMapper,
    private val mainMapper: MainMapper,
    private val windMapper: WindMapper,
    private val weatherMapper: WeatherMapper,
) {

    fun map(weatherApiRes: WeatherApiRes) = WeatherDomain(
        base = weatherApiRes.base,
        clouds = weatherApiRes.cloudsRes.let { cloudsMapper.map(it) },
        coord = weatherApiRes.coordRes.let { coordMapper.map(it) },
        main = weatherApiRes.mainRes.let { mainMapper.map(it) },
        wind = weatherApiRes.windRes.let { windMapper.map(it) },
        weather = weatherApiRes.weatherRes.let { res -> res.map { weatherMapper.map(it) } },
        cod = weatherApiRes.cod,
        dt = weatherApiRes.dt,
        id = weatherApiRes.id,
        name = weatherApiRes.name,
        timezone = weatherApiRes.timezone,
        visibility = weatherApiRes.visibility
    )
}