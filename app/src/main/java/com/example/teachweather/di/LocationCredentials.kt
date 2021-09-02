package com.example.teachweather.di

import com.chibatching.kotpref.Kotpref
import com.chibatching.kotpref.KotprefModel

object LocationCredentials : KotprefModel() {
    var autoSave by booleanPref()
    var cityApi by nullableStringPref()
    var cityUI by nullableStringPref()
    var keyCity by nullableStringPref()
    var lat by floatPref()
    var long by floatPref()
}