package com.example.teachweather.features.weather.data.model.daysRes.mapper

import com.example.teachweather.features.weather.data.model.daysRes.DayRes
import com.example.teachweather.features.weather.data.model.mapper.WindMapper
import com.example.teachweather.features.weather.domain.model.days.Day
import javax.inject.Inject

class DayMapper @Inject constructor(
    private val windMapper: WindMapper,
) {
    fun map(res: DayRes) = Day(
        icon = res.iconRes,
        iconPhrase = res.iconPhraseRes,
        longPhrase = res.longPhraseRes,
        precipitationProbability = res.precipitationProbabilityRes,
        rainProbability = res.rainProbabilityRes,
        shortPhrase = res.shortPhraseRes, wind = res.windRes.let { windMapper.map(it) }
    )
}