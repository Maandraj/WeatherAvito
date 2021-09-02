package com.example.teachweather.features.weather.data.model.mapper

import com.example.teachweather.features.weather.data.model.WeatherRes
import com.example.teachweather.features.weather.domain.model.Weather
import javax.inject.Inject

class WeatherMapper @Inject constructor(
    private val iceMapper: IceMapper,
    private val snowMapper: SnowMapper,
    private val temperatureRealFeelTemperatureMapper: RealFeelTemperatureMapper,
    private val temperatureMapper: TemperatureMapper,
    private val windMapper: WindMapper,
    private val windGustMapper: WindGustMapper,
    private val rainMapper: RainMapper

) {
    fun map(res: WeatherRes) = Weather(
        ice = res.iceRes.let { iceMapper.map(it) },
        rain = res.rainRes.let { rainMapper.map(it) },
        snow = res.snowRes.let { snowMapper.map(it) },
        temperature = res.temperatureRes.let { temperatureMapper.map(it) },
        wind = res.windRes.let { windMapper.map(it) },
        windGust = res.windGustRes.let { windGustMapper.map(it) },
        realFeelTemperature = res.realFeelTemperatureRes.let {
            temperatureRealFeelTemperatureMapper.map(
                it
            )
        },
        cloudCover = res.cloudCoverRes,
        dateTime = res.dateTimeRes,
        epochDateTime = res.epochDateTimeRes,
        hasPrecipitation = res.hasPrecipitationRes,
        iconPhrase = res.iconPhraseRes,
        indoorRelativeHumidity = res.indoorRelativeHumidityRes,
        isDaylight = res.isDaylightRes,
        precipitationProbability = res.precipitationProbabilityRes,
        iceProbability = res.iceProbabilityRes,
        rainProbability = res.rainProbabilityRes,
        relativeHumidity = res.relativeHumidityRes,
        snowProbability = res.snowProbabilityRes,
        thunderstormProbability = res.thunderstormProbabilityRes,
        weatherIcon = res.weatherIconRes,
        uVIndex = res.uVIndexRes,
        uVIndexText = res.uVIndexTextRes
    )
}