package com.example.teachweather.features.weather.domain.model.days

import com.example.teachweather.features.weather.domain.model.Wind

data class Day(
    val hasPrecipitation: Boolean,
    val iceProbability: Int,
    val icon: Int,
    val iconPhrase: String,
    val longPhrase: String,
    val precipitationIntensity: String,
    val precipitationProbability: Int,
    val precipitationType: String,
    val rainProbability: Int,
    val shortPhrase: String,
    val snowProbability: Int,
    val thunderstormProbability: Int,
    val wind: Wind
)