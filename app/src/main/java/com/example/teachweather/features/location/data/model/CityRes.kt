package com.example.teachweather.features.location.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CityRes(
    @Json(name = "AdministrativeArea")
    val administrativeArea: AdministrativeArea,
    @Json(name = "Country")
    val country: Country,
    @Json(name = "EnglishName")
    val englishName: String,
    @Json(name = "GeoPosition")
    val geoPositionRes: GeoPositionRes,
    @Json(name = "Key")
    val key: String,
    @Json(name = "LocalizedName")
    val localizedName: String,
    @Json(name = "PrimaryPostalCode")
    val primaryPostalCode: String,
    @Json(name = "Rank")
    val rank: Int,
    @Json(name = "Region")
    val region: Region,
    @Json(name = "TimeZone")
    val timeZone: TimeZone,
    @Json(name = "Type")
    val type: String,
    @Json(name = "Version")
    val version: Int
)