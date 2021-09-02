package com.example.teachweather.features.weather.domain.model.days

data class Headline(
    val category: String,
    val effectiveDate: String,
    val effectiveEpochDate: Int,
    val endDate: String,
    val endEpochDate: Int,
    val severity: Int,
    val text: String
)