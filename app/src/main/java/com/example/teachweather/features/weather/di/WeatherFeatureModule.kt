package com.example.teachweather.features.weather.di

import com.example.teachweather.features.weather.data.api.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@InstallIn(SingletonComponent::class)
@Module
class WeatherFeatureModule {

    @Provides
    fun provideWeatherApi(retrofit: Retrofit) =
        retrofit.create(WeatherApi::class.java)
}