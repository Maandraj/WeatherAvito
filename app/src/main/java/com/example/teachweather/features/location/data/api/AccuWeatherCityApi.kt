package com.example.teachweather.features.location.data.api

import com.example.teachweather.di.ApiKey
import com.example.teachweather.features.location.data.model.CityRes
import retrofit2.http.GET
import retrofit2.http.Query

interface AccuWeatherCityApi{
    @GET("locations/v1/cities/search")
    suspend fun getCity(
        @Query("q") cityName : String,
        @Query("language") language : String,
        @Query("apikey") apiKey : String = ApiKey.key
        ) : List<CityRes?>
}

