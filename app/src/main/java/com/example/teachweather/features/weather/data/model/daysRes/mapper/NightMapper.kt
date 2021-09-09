package com.example.teachweather.features.weather.data.model.daysRes.mapper

import com.example.teachweather.features.weather.data.model.daysRes.NightRes
import com.example.teachweather.features.weather.data.model.mapper.WindMapper
import com.example.teachweather.features.weather.domain.model.days.Night
import javax.inject.Inject

class NightMapper @Inject constructor(
    private val windMapper: WindMapper,
    private val temperatureDayMapper: TemperatureDayMapper
) {
    fun map(res: NightRes) = Night(
        icon = res.iconRes,
        iconPhrase = res.iconPhraseRes,
        longPhrase = res.longPhraseRes,
        precipitationProbability = res.precipitationProbabilityRes,
        rainProbability = res.rainProbabilityRes,
        shortPhrase = res.shortPhraseRes, wind = res.windRes.let { windMapper.map(it) }
    )
}