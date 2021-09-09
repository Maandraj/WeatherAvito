package com.example.teachweather.features.weather.data.api

import com.example.teachweather.di.ApiKey
import com.example.teachweather.utils.LocationCredentials
import com.example.teachweather.features.weather.data.model.WeatherRes
import com.example.teachweather.features.weather.data.model.daysRes.DailyForecastRes
import com.example.teachweather.features.weather.data.model.daysRes.WeatherDayRes
import com.example.teachweather.features.weather.domain.model.days.WeatherDay
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {


    @GET("forecasts/v1/hourly/12hour/{cityKey}")
    suspend fun getForecastTwelveHours(
        @Path("cityKey") cityKey: String? = LocationCredentials.keyCity,
        @Query("language") language: String,
        @Query("details") details: Boolean = true,
        @Query("metric") metric: Boolean,
        @Query("apikey") apiKey: String = ApiKey.key
    ): Response<List<WeatherRes>>

    @GET("forecasts/v1/daily/5day/{cityKey}")
    suspend fun getForecastWeekDays(
        @Path("cityKey") cityKey: String? = LocationCredentials.keyCity,
        @Query("language") language: String,
        @Query("details") details: Boolean = true,
        @Query("metric") metric: Boolean,
        @Query("apikey") apiKey: String = ApiKey.key
    ): WeatherDayRes



}