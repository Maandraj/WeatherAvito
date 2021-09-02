package com.example.teachweather.features.weather.domain.model.days

data class WeatherDay(
    val dailyForecasts: List<DailyForecast>,
    val headline: Headline
)