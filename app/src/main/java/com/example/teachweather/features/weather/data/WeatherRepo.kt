package com.example.teachweather.features.weather.data

import com.example.teachweather.di.ApiKey
import com.example.teachweather.features.weather.data.api.WeatherApi
import com.example.teachweather.features.weather.data.model.daysRes.mapper.DailyForecastsMapper
import com.example.teachweather.features.weather.data.model.daysRes.mapper.WeatherDayMapper
import com.example.teachweather.features.weather.data.model.mapper.WeatherMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepo @Inject constructor(
    private val api: WeatherApi,
    private val weatherMapper: WeatherMapper,
    private val weatherDayMapper: WeatherDayMapper,
    private val dailyForecastsMapper: DailyForecastsMapper
) {
    var langError = false
    suspend fun getWeatherTwelveHours(language: String, metric: Boolean) =
        withContext(Dispatchers.IO) {
            val response = api.getForecastTwelveHours(language = language, metric = metric)
            if (response.isSuccessful) {
                return@withContext api.getForecastTwelveHours(language = language, metric = metric)
                    .let { res -> res.body()!!.map { weatherMapper.map(it) } }
            } else {
                if (response.code() == 200) {
                    langError = true
                    return@withContext  api.getForecastTwelveHours(language = "en", metric = metric)
                        .let { res -> res.body()!!.map { weatherMapper.map(it) } }
                }

                when {
                    response.code() != 401 -> {
                    }
                    else -> {
                        if (!langError) {
                            return@withContext     api.getForecastTwelveHours(
                                language = language,
                                metric = metric,
                                apiKey = ApiKey.keyTwo
                            )
                                .let { res -> res.body()!!.map { weatherMapper.map(it) } }
                        } else {
                            return@withContext    api.getForecastTwelveHours(
                                language = "en",
                                metric = metric,
                                apiKey = ApiKey.keyTwo
                            )
                        }
                    }
                }

            }

        }
    suspend fun getWeatherWeekDays(language: String, metric: Boolean ) = withContext(Dispatchers.IO) {
        api.getForecastWeekDays(language = language, metric = metric)
            .let { weatherDayMapper.map(it) }
    }
}
