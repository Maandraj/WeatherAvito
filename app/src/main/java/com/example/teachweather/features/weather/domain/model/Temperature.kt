package com.example.teachweather.features.weather.domain.model

data class Temperature(
    val unit: String,
    val unitType: Int,
    val value: Double
)