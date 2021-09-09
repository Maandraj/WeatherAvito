package com.example.teachweather.features.weather.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.teachweather.R
import com.example.teachweather.databinding.ForecastTodayItemBinding
import com.example.teachweather.features.weather.domain.model.Weather

import com.example.teachweather.features.weather.utils.WeatherIcon
import java.text.SimpleDateFormat


class WeatherTwelveHoursAdapter(
    private val forecast: List<Weather>,
    private val clickListener: onItemClick
) :
    RecyclerView.Adapter<WeatherTwelveHoursAdapter.WeatherHolder>() {
    var selectedPosition = 0

    class WeatherHolder(view: View) : RecyclerView.ViewHolder(view) {
        val viewBinding: ForecastTodayItemBinding by viewBinding(ForecastTodayItemBinding::bind)

        val iconCard = viewBinding.ivIconWeatherCard
        val card = viewBinding.cvRootItem
        val temp = viewBinding.tvTempCard
        val time = viewBinding.tvTimeCard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.forecast_today_item, parent, false)
        return WeatherHolder(itemView)
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        val item = forecast[position]


        holder.card.isCheckable = position == selectedPosition
        if (holder.card.isCheckable) {
            holder.card.backgroundTintList =
                holder.itemView.resources.getColorStateList(R.color.card_background)
            holder.card.layoutParams.height =
                holder.itemView.resources.getDimensionPixelSize(R.dimen.card_height) + 50
            holder.card.requestLayout()
        } else {
            holder.card.layoutParams.height =
                holder.itemView.resources.getDimensionPixelSize(R.dimen.card_height)

            holder.card.backgroundTintList =
                holder.itemView.resources.getColorStateList(R.color.white).withAlpha(0)
            holder.card.requestLayout()
        }
        holder.card.setOnClickListener {
            clickListener.hourClick(item)
            selectedPosition = position
            notifyDataSetChanged() // Important to call and it notifies of everything
        }
        val formatter = SimpleDateFormat("h:mm a")
        holder.temp.text = "${item.temperature.value.toInt()}°${item.temperature.unit}"
        holder.time.text = formatter.format(item.epochDateTime * 1000L)
        holder.iconCard.setImageResource(WeatherIcon.getIcon(item.weatherIcon))
    }

    override fun getItemCount(): Int = forecast.size
    interface onItemClick {
        fun hourClick(weather: Weather)
    }
}