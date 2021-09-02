package com.example.teachweather.features.weather.presentation

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.teachweather.R
import com.example.teachweather.databinding.FragmentWeatherBinding
import com.example.teachweather.di.LocationCredentials
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class WeatherFragment : Fragment(R.layout.fragment_weather) {
    private val viewBinding: FragmentWeatherBinding by viewBinding(FragmentWeatherBinding::bind)
    private val viewModel: WeatherViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val geocoderApi = Geocoder(requireContext(), Locale.getDefault())
        val addresses: Address = geocoderApi.getFromLocation(
            LocationCredentials.lat.toDouble(),
            LocationCredentials.long.toDouble(), 1)[0]
        viewModel.setCurrentCity(addresses.locality)
        viewModel.forecast12Hours.observe(viewLifecycleOwner, {
            Log.i("Weather", "${it[0].temperature.value} ${it[0].temperature.unit}")
        })
        viewModel.currentCity.observe(viewLifecycleOwner, {
            viewBinding.tvCity.text =  it
        })

    }
}