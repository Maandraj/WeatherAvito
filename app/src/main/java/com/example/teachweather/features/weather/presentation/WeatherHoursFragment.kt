package com.example.teachweather.features.weather.presentation

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.teachweather.R
import com.example.teachweather.databinding.FragmentWeatherHoursBinding
import com.example.teachweather.features.weather.domain.model.Weather
import com.example.teachweather.utils.LocationCredentials
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


import com.example.teachweather.features.weather.presentation.adapter.WeatherTwelveHoursAdapter
import com.example.teachweather.features.weather.utils.WeatherIcon

import java.text.SimpleDateFormat

import java.sql.Date
import java.sql.Timestamp
import kotlin.time.ExperimentalTime


@AndroidEntryPoint
class WeatherHoursFragment : Fragment(R.layout.fragment_weather_hours), WeatherTwelveHoursAdapter.onItemClick {
    private val viewBinding: FragmentWeatherHoursBinding by viewBinding(FragmentWeatherHoursBinding::bind)
    private val hoursViewModel: WeatherHoursViewModel by viewModels()
    private lateinit var adapter: WeatherTwelveHoursAdapter

    @ExperimentalTime
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hoursViewModel.currentCity.observe(viewLifecycleOwner, {
            viewBinding.tvCity.text = it
        })
        val geocoderApi = Geocoder(requireContext(), Locale.getDefault())
        val addresses: Address = geocoderApi.getFromLocation(
            LocationCredentials.lat.toDouble(),
            LocationCredentials.long.toDouble(), 1
        )[0]
        hoursViewModel.setCurrentCity("${addresses.countryName}, ${addresses.locality}")
        hoursViewModel.forecast12Hours.observe(viewLifecycleOwner, {
            viewBinding.tvDays.text = "${it.size} ${resources.getString(R.string.days)}"
            viewBinding.tvDays.setOnClickListener{
               findNavController().navigate(R.id.weatherDaysFragment)
           }
            val firstHour = it[0]
            //  val drawable = resources.getDrawable(WeatherIcon().getIcon(firstHour.weatherIcon))
            val date = Date(Timestamp(firstHour.epochDateTime.toLong()).time)
            val formatter = SimpleDateFormat("d MMM EEE")
            viewBinding.tvDay.text = formatter.format(firstHour.epochDateTime * 1000L)
            viewBinding.tvTemp.text = "${firstHour.temperature.value.toInt()}°${firstHour.temperature.unit}"
            viewBinding.tvStatusWeather.text = "${firstHour.iconPhrase}"
            viewBinding.tvHumidityValue.text = "${firstHour.rainProbability}%"
            viewBinding.tvWindValue.text = "${firstHour.wind.speed.value} ${firstHour.wind.speed.unit}"
            viewBinding.tvCloudCoverValue.text = "${firstHour.cloudCover}%"
            viewBinding.ivIconWeather.setImageResource(WeatherIcon.getIcon(firstHour.weatherIcon))
            adapter = WeatherTwelveHoursAdapter(it, this)
            viewBinding.recyclerView.adapter = adapter
            Log.i("Weather", "${it[0].temperature.value.toInt()}°${it[0].temperature.unit}")
        })

    }





    override fun hourClick(weather: Weather) {

        //  val drawable = resources.getDrawable(WeatherIcon().getIcon(firstHour.weatherIcon))
        val date = Date(Timestamp(weather.epochDateTime.toLong()).time)
        val formatter = SimpleDateFormat("d MMM EEE")
        viewBinding.tvDay.text = formatter.format(weather.epochDateTime * 1000L)
        viewBinding.tvWindValue.text = "${weather.wind.speed.value} ${weather.wind.speed.unit}"
        viewBinding.tvCloudCoverValue.text = "${weather.cloudCover}%"
        viewBinding.tvTemp.text = "${weather.temperature.value.toInt()}°${weather.temperature.unit}"
        viewBinding.tvStatusWeather.text = "${weather.iconPhrase}"
        viewBinding.tvHumidityValue.text = "${weather.rainProbability}%"
        viewBinding.ivIconWeather.setImageResource(WeatherIcon.getIcon(weather.weatherIcon))

    }
}