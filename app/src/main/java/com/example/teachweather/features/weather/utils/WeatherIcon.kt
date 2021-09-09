package com.example.teachweather.features.weather.utils

import android.graphics.drawable.Drawable
import com.example.teachweather.R

object WeatherIcon {
     fun getIcon(id:Int) : Int{
         return when(id){
             1-> R.drawable.sun
             2->R.drawable.sun
             3->R.drawable.sun_cloud_wind
             4->R.drawable.sun_cloud_wind
             5->R.drawable.sun_fog
             6->R.drawable.sun_cloud
             7->R.drawable.sun_cloud
             8->R.drawable.cloud
             11->R.drawable.cloud
             12->R.drawable.cloud_rain_wind
             13->R.drawable.sun_cloud_rain
             14->R.drawable.sun_cloud_rain
             15->R.drawable.cloud_rain_storm
             16->R.drawable.sun_cloud_rain_storm
             17->R.drawable.sun_cloud_rain_storm
             18->R.drawable.cloud_rain
             19->R.drawable.cloud_snow_big
             20->R.drawable.sun_cloud_wind
             21->R.drawable.sun_cloud_wind
             22->R.drawable.cloud_snow
             23->R.drawable.cloud_snow
             24->R.drawable.freeze
             25->R.drawable.cloud_snow_rain
             26->R.drawable.cloud_rain_wind
             29->R.drawable.cloud_snow_rain
             30->R.drawable.sun
             31->R.drawable.freeze
             32->R.drawable.sun_fog
             33->R.drawable.moon
             34->R.drawable.moon
             35->R.drawable.moon_cloud
             36->R.drawable.moon_cloud
             37->R.drawable.moon_fog
             38->R.drawable.moon_cloud
             39->R.drawable.moon_cloud_rain
             40->R.drawable.moon_cloud_rain
             41->R.drawable.moon_cloud_storm
             42->R.drawable.moon_cloud_storm
             43->R.drawable.moon_cloud_wind
             44->R.drawable.moon_snow
             else -> 1
         }
     }
}