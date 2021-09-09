package com.example.teachweather.features.weather.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teachweather.features.weather.domain.WeatherInteractor
import com.example.teachweather.features.weather.domain.model.Weather
import com.example.teachweather.features.weather.domain.model.days.DailyForecast
import com.example.teachweather.features.weather.domain.model.days.WeatherDay
import com.example.teachweather.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherDaysViewModel @Inject constructor(
    private val weatherInteractor: WeatherInteractor
) : ViewModel() {

    private val _currentCity = MutableLiveData<String>()
    val currentCity = _currentCity.asLiveData()

    private val _forecastWeek = MutableLiveData<WeatherDay>()
    val forecastWeek = _forecastWeek.asLiveData()




    init {
        viewModelScope.launch {
            val forecastWeekHours = weatherInteractor.getWeatherWeekHours()
            _forecastWeek.postValue(forecastWeekHours)


        }
    }
    fun setCurrentCity(address:String){
        viewModelScope.launch {
            _currentCity.postValue(address)
        }
    }
}