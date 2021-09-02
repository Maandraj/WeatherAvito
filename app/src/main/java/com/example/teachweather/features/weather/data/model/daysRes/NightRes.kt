package com.example.teachweather.features.weather.data.model.daysRes


import com.example.teachweather.features.weather.data.model.EvapotranspirationRes
import com.example.teachweather.features.weather.data.model.SolarIrradianceRes
import com.example.teachweather.features.weather.data.model.WindRes
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class NightRes(
    @Json(name = "CloudCover")
    val cloudCoverRes: Int,
    @Json(name = "Evapotranspiration")
    val evapotranspirationRes: EvapotranspirationRes,
    @Json(name = "HasPrecipitation")
    val hasPrecipitationRes: Boolean,
    @Json(name = "HoursOfPrecipitation")
    val hoursOfPrecipitationRes: Int,
    @Json(name = "IceProbability")
    val iceProbabilityRes: Int,
    @Json(name = "Icon")
    val iconRes: Int,
    @Json(name = "IconPhrase")
    val iconPhraseRes: String,
    @Json(name = "LongPhrase")
    val longPhraseRes: String,
    @Json(name = "PrecipitationProbability")
    val precipitationProbabilityRes: Int,
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