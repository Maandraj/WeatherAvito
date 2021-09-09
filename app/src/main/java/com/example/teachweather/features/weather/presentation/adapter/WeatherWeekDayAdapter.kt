//package com.example.teachweather.features.weather.presentation.adapter
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.teachweather.R
//import com.example.teachweather.databinding.ForecastItemBinding
//
//import com.example.teachweather.features.weather.domain.model.days.WeatherDay
//import java.sql.Date
//import java.sql.Timestamp
//import java.text.SimpleDateFormat
//
//class WeatherWeekDayAdapter(private val forecast: WeatherDay) :
//    RecyclerView.Adapter<WeatherWeekDayAdapter.WeatherHolder>() {
//
//    class WeatherHolder(view: View) : RecyclerView.ViewHolder(view) {
//        private val viewBinding: ForecastItemBinding by viewBinding(ForecastItemBinding::bind)
//        val iconCard = viewBinding.ivIconWeatherCard
//        val minTemp = viewBinding.tvMinTempCard
//      //  val maxTemp = viewBinding.tvMaxTempCard
//        val day = viewBinding.tvDayCard
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
//        val itemView =
//            LayoutInflater.from(parent.context).inflate(R.layout.forecast_item, parent, false)
//        return WeatherHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
//        val item = forecast.dailyForecasts[position]
//        holder.minTemp.text =
//            "${item.temperatureDay.minimum.value} ${item.temperatureDay.minimum.unit}"
//        holder.maxTemp.text =
//            "${item.temperatureDay.maximum.value} ${item.temperatureDay.maximum.unit}"
//        val timestamp = Timestamp(item.epochDate.toLong())
//        val dateFormat = SimpleDateFormat("DD").format(Date(timestamp.time))
//        holder.day.text = dateFormat
//    }
//
//    override fun getItemCount(): Int = forecast.dailyForecasts.size
//
//}