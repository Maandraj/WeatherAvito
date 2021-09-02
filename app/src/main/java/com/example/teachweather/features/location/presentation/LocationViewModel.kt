package com.example.teachweather.features.location.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teachweather.di.LocationCredentials
import com.example.teachweather.features.location.domain.LocationInteractor
import com.example.teachweather.utills.asLiveData
import com.google.android.libraries.places.api.model.Place
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationInteractor: LocationInteractor
) : ViewModel() {
    val key = "AIzaSyBIE3HoKztVwwllsNFDBrYF9l8F6ZRbakM"

    private val _isSelectException = MutableLiveData<Boolean>()
    val isSelectException = _isSelectException.asLiveData()

    private val _successLocation = MutableLiveData<Boolean>()
    val successLocation = _successLocation.asLiveData()

    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState = _loadingState.asLiveData()

    private val _selectPlace = MutableLiveData<Place>()
    val selectPlace = _selectPlace.asLiveData()

    init {
        viewModelScope.launch {
            if (LocationCredentials.cityUI == null || LocationCredentials.cityApi == null) {
                _loadingState.postValue(true)
                _successLocation.postValue(false)
            } else {
                _loadingState.postValue(false)
                _successLocation.postValue(true)

            }
        }
    }

    fun setPlace(place: Place) {
        viewModelScope.launch {
            _selectPlace.postValue(place)
        }
    }

    fun setLocation(
        locationApi: String? = null,
        locationUi: String? = null,
        lat: Double? = null,
        long: Double? = null
    ) {
        viewModelScope.launch {
            LocationCredentials.cityApi = locationApi
            LocationCredentials.cityUI = locationUi
            if (LocationCredentials.cityUI == null || LocationCredentials.cityApi == null) {
                _successLocation.postValue(false)
            } else {
                val city = locationInteractor.getCity(locationUi!!)
                if (city != null) {
                    LocationCredentials.autoSave = true
                    LocationCredentials.keyCity = city.key
                    LocationCredentials.lat = lat!!.toFloat()
                    LocationCredentials.long = long!!.toFloat()
                    _successLocation.postValue(true)
                }else{
                    LocationCredentials.cityApi = null
                    LocationCredentials.cityUI = null
                    _isSelectException.postValue(false)
                }
            }
            _loadingState.postValue(false)

        }
    }

    fun setSelectionException(isSuccess: Boolean) {
        viewModelScope.launch {
            _isSelectException.postValue(isSuccess)
        }
    }
}