package com.example.teachweather.features.location.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teachweather.di.LocationCredentials
import com.example.teachweather.utills.asLiveData
import com.google.android.libraries.places.api.model.Place
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationViewModel @Inject constructor() : ViewModel() {
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
            if (LocationCredentials.cityUI == null || LocationCredentials.cityApi == null){
                _loadingState.postValue(true)
                _successLocation.postValue(false)
            }else{
                _loadingState.postValue(false)
                _successLocation.postValue(true)

            }
        }
    }

    fun setPlace(place: Place){
       viewModelScope.launch {
           _selectPlace.postValue(place)
       }
    }
    fun setLocation(locationApi: String?, locationUi : String?){
        viewModelScope.launch {
            _loadingState.postValue(false)
            LocationCredentials.cityApi = locationApi
            LocationCredentials.cityUI = locationUi
            if (LocationCredentials.cityUI == null || LocationCredentials.cityApi == null ){
                _successLocation.postValue(false)
                LocationCredentials.cityApi = null
                LocationCredentials.cityUI = null
            }else{
                _successLocation.postValue(true)
            }
        }
    }
    fun setSelectionException(isSuccess : Boolean){
        viewModelScope.launch {
            _isSelectException.postValue(isSuccess)
        }
    }
}