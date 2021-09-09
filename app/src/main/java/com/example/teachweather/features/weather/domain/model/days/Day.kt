package com.example.teachweather.features.weather.domain.model.days

import com.example.teachweather.features.weather.domain.model.Wind

data class Day(
    val icon: Int,
    val iconPhrase: String,
    val longPhrase: String,
    val precipitationProbability: Int?,
    val rainProbability: Int,
    val shortPhrase: String,
    val wind: Wind
)