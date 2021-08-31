package com.example.teachweather.features.weather.data.api

import com.example.teachweather.features.weather.data.model.WeatherApiRes
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {
    @GET("/weather?q={city}&appid={apiKey}&lang=ru")
    suspend fun getCityWeather(@Path("city") city : String,
                               @Path("apikey")apiKey : String = "a9d853c849dc12c76b90f26857213f0e") : WeatherApiRes
}