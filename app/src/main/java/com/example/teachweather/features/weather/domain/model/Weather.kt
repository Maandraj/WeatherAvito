package com.example.teachweather.features.weather.domain.model

data class Weather(
    val cloudCover: Int,
    val dateTime: String,
    val epochDateTime: Int,
    val hasPrecipitation: Boolean,
    val ice: Ice,
    val iceProbability: Int,
    val iconPhrase: String,
    val indoorRelativeHumidity: Int,
    val isDaylight: Boolean,
    val precipitationProbability: Int,
    val rain: Rain,
    val rainProbability: Int,
    val realFeelTemperature: RealFeelTemperature,
    val relativeHumidity: Int,
    val snow: Snow,
    val snowProbability: Int,
    val temperature: Temperature,
    val thunderstormProbability: Int,
    val uVIndex: Int,
    val uVIndexText: String,
    val weatherIcon: Int,
    val wind: Wind,
    val windGust: WindGust
)