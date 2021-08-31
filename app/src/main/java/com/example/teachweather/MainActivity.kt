package com.example.teachweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import com.example.teachweather.R
import com.example.teachweather.di.LocationCredentials
import com.example.teachweather.features.location.presentation.SettingsDialogFragment
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //     SettingsDialogFragment().show(supportFragmentManager, SettingsDialogFragment.TAG)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController


        navController.setGraph(
            if (LocationCredentials.autoSave)
                R.navigation.secured_graph
            else if (LocationCredentials.cityUI == null && LocationCredentials.cityApi == null)
                R.navigation.secured_graph
            else
                R.navigation.unsecured_graph

        )
    }
}