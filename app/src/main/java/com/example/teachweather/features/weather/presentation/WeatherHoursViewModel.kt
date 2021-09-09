package com.example.teachweather.features.weather.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teachweather.features.weather.domain.WeatherInteractor
import com.example.teachweather.features.weather.domain.model.Weather
import com.example.teachweather.features.weather.domain.model.days.WeatherDay
import com.example.teachweather.utils.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherHoursViewModel @Inject constructor(
    private val weatherInteractor: WeatherInteractor
) : ViewModel() {

    private val _currentCity = MutableLiveData<String>()
    val currentCity = _currentCity.asLiveData()

    private val _forecast12Hours = MutableLiveData<List<Weather>>()
    val forecast12Hours = _forecast12Hours.asLiveData()




    init {
        viewModelScope.launch {
            val forecast12Hours = weatherInteractor.getWeather12Hours()
            _forecast12Hours.postValue(forecast12Hours as List<Weather>?)


        }
    }
    fun setCurrentCity(address:String){
        viewModelScope.launch {
            _currentCity.postValue(address)
        }
    }
}