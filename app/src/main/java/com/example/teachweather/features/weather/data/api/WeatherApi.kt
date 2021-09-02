package com.example.teachweather.features.weather.data.api

import com.example.teachweather.di.LocationCredentials
import com.example.teachweather.features.weather.data.model.WeatherRes
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecasts/v1/hourly/12hour/{cityKey}")
    suspend fun getForecast12hours(
        @Path("cityKey") cityKey : String? = LocationCredentials.keyCity,
        @Query("language") language : String,
        @Query("details") details : Boolean = true,
        @Query("metric") metric : Boolean,
        @Query("apikey") apiKey : String = "acRKarlW4gg8iDT4VLZuAZwGM2CX2JrH"
    ) : List<WeatherRes>
}