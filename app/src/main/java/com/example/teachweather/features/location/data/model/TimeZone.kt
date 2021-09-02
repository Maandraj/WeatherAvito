package com.example.teachweather.features.location.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TimeZone(
    @Json(name = "Code")
    val code: String,
    @Json(name = "GmtOffset")
    val gmtOffset: Int,
    @Json(name = "IsDaylightSaving")
    val isDaylightSaving: Boolean,
    @Json(name = "Name")
    val name: String,
    @Json(name = "NextOffsetChange")
    val nextOffsetChange: String?
)