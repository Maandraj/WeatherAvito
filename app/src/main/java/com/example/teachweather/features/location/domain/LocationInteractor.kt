package com.example.teachweather.features.location.domain

import android.content.Context
import com.example.teachweather.features.location.data.LocationRepo
import java.io.InputStream
import java.util.*
import javax.inject.Inject

class LocationInteractor @Inject constructor(
    private val locationRepo: LocationRepo
) {
    suspend fun getCity(cityName : String) = locationRepo.getCity(cityName, Locale.getDefault().language)
}