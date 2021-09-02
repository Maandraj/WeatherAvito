package com.example.teachweather.features.weather.data.model.daysRes


import com.example.teachweather.features.weather.data.model.WindRes
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class DayRes(
    @Json(name = "CloudCover")
    val cloudCoverRes: Int,
    @Json(name = "HasPrecipitation")
    val hasPrecipitationRes: Boolean,
    @Json(name = "IceProbability")
    val iceProbabilityRes: Int,
    @Json(name = "Icon")
    val iconRes: Int,
    @Json(name = "IconPhrase")
    val iconPhraseRes: String,
    @Json(name = "LongPhrase")
    val longPhraseRes: String,
    @Json(name = "PrecipitationIntensity")
    val precipitationIntensityRes: String,
    @Json(name = "PrecipitationProbability")
    val precipitationProbabilityRes: Int,
    @Json(name = "PrecipitationType")
    val precipitationTypeRes: String,
    @Json(name = "RainProbability")
    val rainProbabilityRes: Int,
    @Json(name = "ShortPhrase")
    val shortPhraseRes: String,
    @Json(name = "SnowProbability")
    val snowProbabilityRes: Int,
    @Json(name = "ThunderstormProbability")
    val thunderstormProbabilityRes: Int,
    @Json(name = "Wind")
    val windRes: WindRes
)