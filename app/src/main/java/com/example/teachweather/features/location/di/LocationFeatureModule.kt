package com.example.teachweather.features.location.di

import com.example.teachweather.features.location.data.api.AccuWeatherCityApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class LocationFeatureModule {
    @Provides
    fun provideLocationApi(retrofit: Retrofit) =
        retrofit.create(AccuWeatherCityApi::class.java)
}