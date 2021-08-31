package com.example.teachweather.features.location.presentation

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teachweather.features.location.domain.LocationInteractor
import com.example.teachweather.features.location.domain.model.City
import com.example.teachweather.utills.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsDialogViewModel @Inject constructor(
    private val locationInteractor: LocationInteractor,
) : ViewModel() {
    private val _city = MutableLiveData<List<City>>()
    val city get() = _city.asLiveData()

    fun getCities(context: Context){
        viewModelScope.launch {
            _city.value = locationInteractor.getCities(context)
        }
    }
}