package com.example.teachweather.features.weather.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherRes(
    @Json(name = "CloudCover")
    val cloudCoverRes: Int,
    @Json(name = "DateTime")
    val dateTimeRes: String,
    @Json(name = "EpochDateTime")
    val epochDateTimeRes: Long,
    @Json(name = "Evapotranspiration")
    val evapotranspirationRes: EvapotranspirationRes,
    @Json(name = "HasPrecipitation")
    val hasPrecipitationRes: Boolean,
    @Json(name = "Ice")
    val iceRes: IceRes,
    @Json(name = "IceProbability")
    val iceProbabilityRes: Int,
    @Json(name = "IconPhrase")
    val iconPhraseRes: String,
    @Json(name = "IndoorRelativeHumidity")
    val indoorRelativeHumidityRes: Int,
    @Json(name = "IsDaylight")
    val isDaylightRes: Boolean,
    @Json(name = "PrecipitationProbability")
    val precipitationProbabilityRes: Int,
    @Json(name = "Rain")
    val rainRes: RainRes,
    @Json(name = "RainProbability")
    val rainProbabilityRes: Int,
    @Json(name = "RealFeelTemperature")
    val realFeelTemperatureRes: RealFeelTemperatureRes,
    @Json(name = "RelativeHumidity")
    val relativeHumidityRes: Int,
    @Json(name = "Snow")
    val snowRes: SnowRes,
    @Json(name = "SnowProbability")
    val snowProbabilityRes: Int,
    @Json(name = "SolarIrradiance")
    val solarIrradianceRes: SolarIrradianceRes,
    @Json(name = "Temperature")
    val temperatureRes: TemperatureRes,
    @Json(name = "ThunderstormProbability")
    val thunderstormProbabilityRes: Int,
    @Json(name = "TotalLiquid")
    val totalLiquidRes: TotalLiquidRes,
    @Json(name = "UVIndex")
    val uVIndexRes: Int,
    @Json(name = "UVIndexText")
    val uVIndexTextRes: String,
    @Json(name = "Visibility")
    val visibilityRes: VisibilityRes,
    @Json(name = "WeatherIcon")
    val weatherIconRes: Int,
    @Json(name = "Wind")
    val windRes: WindRes,
    @Json(name = "WindGust")
    val windGustRes: WindGustRes
)