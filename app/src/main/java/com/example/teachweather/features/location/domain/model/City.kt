package com.example.teachweather.features.location.domain.model

data class City(
    val coordLocation: CoordLocation,
    val country: String,
    val id: Int,
    val name: String,
    val state: String
)