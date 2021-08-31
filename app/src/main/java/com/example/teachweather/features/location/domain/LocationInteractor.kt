package com.example.teachweather.features.location.domain

import android.content.Context
import com.example.teachweather.features.location.data.LocationRepo
import java.io.InputStream
import javax.inject.Inject

class LocationInteractor @Inject constructor(
    private val locationRepo: LocationRepo
) {
    suspend fun getCities(context: Context) = locationRepo.getCity(context)
}