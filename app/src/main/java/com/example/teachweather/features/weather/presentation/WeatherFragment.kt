package com.example.teachweather.features.weather.presentation

import android.annotation.SuppressLint
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.util.TimeUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.teachweather.R
import com.example.teachweather.databinding.FragmentWeatherBinding
import com.example.teachweather.di.LocationCredentials
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import com.jjoe64.graphview.series.LineGraphSeries


import by.kirich1409.viewbindingdelegate.viewBinding

import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter
import com.jjoe64.graphview.DefaultLabelFormatter
import java.text.Format
import java.text.SimpleDateFormat
import kotlin.collections.ArrayList
import com.jjoe64.graphview.series.DataPointInterface

import com.jjoe64.graphview.series.PointsGraphSeries
import com.jjoe64.graphview.series.PointsGraphSeries.CustomShape
import java.sql.Timestamp
import java.text.DecimalFormat
import kotlin.time.ExperimentalTime
import kotlin.time.milliseconds


@AndroidEntryPoint
class WeatherFragment : Fragment(R.layout.fragment_weather) {
    private val viewBinding: FragmentWeatherBinding by viewBinding(FragmentWeatherBinding::bind)
    private val viewModel: WeatherViewModel by viewModels()

    @ExperimentalTime
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
// generate Dates
        // generate Dates

        val graph = viewBinding.graph

        graph.gridLabelRenderer.labelFormatter = object : DefaultLabelFormatter(
            DecimalFormat("##################"),
            DecimalFormat("#.##")) {
            override fun formatLabel(value: Double, isValueX: Boolean): String {
                if (isValueX) {
                    val newValue = value.toBigDecimal().toPlainString()
                        .replace(",", "" )
                        .replace(".", "" )
                    val stamp = Timestamp(newValue.toLong())
                    val formatter = SimpleDateFormat("HH:mm").format(Date(stamp.time))
                    return formatter
                }
                return super.formatLabel(value, isValueX)
            }
        }
        viewModel.forecast12Hours.observe(viewLifecycleOwner, {
            val seriesArray : ArrayList<DataPoint> = arrayListOf()
            for (item in it){



                seriesArray.add(DataPoint( item.epochDateTime.toDouble(),item.temperature.value))
            }

            val array = arrayOfNulls<DataPoint>(seriesArray.size)
            val series = PointsGraphSeries(
                seriesArray.toArray(array)
            )
         //   series.isDrawDataPoints = true
            series.color = Color.BLUE
            series.size = 30f
        //    series.dataPointsRadius = 10f
            graph.addSeries(series)

            series.setCustomShape(CustomShape { canvas, paint, x, y, dataPoint ->
                paint.color = Color.BLACK

                paint.textSize = 38F
                canvas.drawText(dataPoint.y.toString(), x, y, paint)
            })


            graph.gridLabelRenderer.numHorizontalLabels = 0 // only 4 because of the space
            graph.gridLabelRenderer.numVerticalLabels = 0 // only 4 because of the space
            graph.viewport.isScalable = true
            graph.viewport.isXAxisBoundsManual = true
            graph.viewport.isYAxisBoundsManual = true
            graph.viewport.isScrollable = true
            graph.gridLabelRenderer.setHumanRounding(false)
        })




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