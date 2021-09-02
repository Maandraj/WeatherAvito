package com.example.teachweather.features.location.data

import android.content.Context
import com.example.teachweather.features.location.data.api.AccuWeatherCityApi
import com.example.teachweather.features.location.data.model.mapper.CityMapper

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.intellij.lang.annotations.Language
import java.io.InputStream
import java.lang.Exception
import javax.inject.Inject

class LocationRepo @Inject constructor(
    private val cityMapper: CityMapper,
    private val api: AccuWeatherCityApi
) {
    suspend fun getCity(cityName: String, language: String) = withContext(Dispatchers.IO) {
        val city = api.getCity(cityName, language)
        if (city.isNotEmpty()) {

            city[0].let { it?.let { it1 -> cityMapper.map(it1) } }
        } else {
            null
        }
    }

}