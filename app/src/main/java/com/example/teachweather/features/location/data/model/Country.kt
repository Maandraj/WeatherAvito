package com.example.teachweather.features.location.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Country(
    @Json(name = "EnglishName")
    val englishName: String,
    @Json(name = "ID")
    val iD: String,
    @Json(name = "LocalizedName")
    val localizedName: String
)