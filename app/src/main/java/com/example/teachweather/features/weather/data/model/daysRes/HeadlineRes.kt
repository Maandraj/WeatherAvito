package com.example.teachweather.features.weather.data.model.daysRes


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class HeadlineRes(
    @Json(name = "Category")
    val categoryRes: String,
    @Json(name = "EffectiveDate")
    val effectiveDateRes: String,
    @Json(name = "EffectiveEpochDate")
    val effectiveEpochDateRes: Int,
    @Json(name = "EndDate")
    val endDateRes: String,
    @Json(name = "EndEpochDate")
    val endEpochDateRes: Int,
    @Json(name = "Severity")
    val severityRes: Int,
    @Json(name = "Text")
    val textRes: String
)