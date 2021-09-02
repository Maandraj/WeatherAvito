package com.example.teachweather.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModel {
    @Provides
    @Singleton
    fun provideOkHttp( gzipInterceptor : GzipInterceptor): OkHttpClient =

        OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }.addInterceptor(gzipInterceptor)
            .build()

    @Provides
    @Singleton
    fun providerMoshi(): Moshi = Moshi.Builder().build()


    @Provides
    @Singleton
    fun provideWeatherRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(OPENWEATHERM_API_BASE_URL)
        .client(okHttpClient)
        .build()
}

private const val OPENWEATHERM_API_BASE_URL = "http://dataservice.accuweather.com/"
