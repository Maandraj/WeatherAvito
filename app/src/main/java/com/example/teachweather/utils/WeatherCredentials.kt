package com.example.teachweather.utils

import com.chibatching.kotpref.Kotpref
import com.chibatching.kotpref.KotprefModel

object WeatherCredentials : KotprefModel() {
    var metric by booleanPref()
}