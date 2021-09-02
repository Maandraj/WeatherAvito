package com.example.teachweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.navigation.fragment.NavHostFragment

import com.example.teachweather.di.LocationCredentials

import dagger.hilt.android.AndroidEntryPoint


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
            else if (LocationCredentials.keyCity == null  )
                R.navigation.secured_graph
            else
                R.navigation.unsecured_graph

        )
    }
}