package com.example.teachweather.features.location.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AdministrativeArea(
    @Json(name = "CountryID")
    val countryID: String,
    @Json(name = "EnglishName")
    val englishName: String,
    @Json(name = "EnglishType")
    val englishType: String,
    @Json(name = "ID")
    val iD: String,
    @Json(name = "Level")
    val level: Int,
    @Json(name = "LocalizedName")
    val localizedName: String,
    @Json(name = "LocalizedType")
    val localizedType: String
)