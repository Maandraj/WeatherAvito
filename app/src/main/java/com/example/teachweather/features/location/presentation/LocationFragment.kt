package com.example.teachweather.features.location.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.teachweather.R
import com.example.teachweather.databinding.FragmentLocationBinding
import com.example.teachweather.di.LocationCredentials
import com.example.teachweather.features.location.presentation.SettingsDialogFragment.Companion.TAG
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.model.TypeFilter
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.FetchPlaceResponse
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.EasyPermissions
import java.util.*


@AndroidEntryPoint
class LocationFragment : Fragment(R.layout.fragment_location),
    EasyPermissions.PermissionCallbacks {
    private val viewBinding: FragmentLocationBinding by viewBinding(FragmentLocationBinding::bind)
    private lateinit var autocompleteFragment: AutocompleteSupportFragment
    private val viewModel: LocationViewModel by viewModels()
    private var placeFields: List<Place.Field> = listOf()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        placeFields = listOf(Place.Field.NAME, Place.Field.LAT_LNG)
        LocationCredentials.autoSave = true
        Places.initialize(
            requireContext(),
            viewModel.key,
            Locale.getDefault()
        )
        if (LocationCredentials.cityApi == null)
            openPhotoPicker()

        autocompleteFragment =
            childFragmentManager.findFragmentById(R.id.autocomplete_fragment)
                    as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(listOf(Place.Field.ID, Place.Field.NAME))
        autocompleteFragment.setTypeFilter(TypeFilter.CITIES)
        autocompleteFragment.setText(LocationCredentials.cityUI)

        val autocompleteView = autocompleteFragment.requireView()
        autocompleteView.findViewById<View>(R.id.places_autocomplete_clear_button)
            .setOnClickListener { view ->
                autocompleteFragment.setText("")
                view.visibility = View.GONE
                viewBinding.btnSave.visibility = View.GONE
                viewModel.setLocation(null, null)
            }
        val editComplete =
            autocompleteView.findViewById<EditText>(R.id.places_autocomplete_search_input)
        editComplete.setTextColor(resources.getColor(R.color.white))

        viewModel.loadingState.observe(viewLifecycleOwner, {
            viewBinding.progress.root.isVisible = it
        })

        viewModel.successLocation.observe(viewLifecycleOwner, {
            viewBinding.btnSave.isVisible = it
        })

        viewModel.isSelectException.observe(viewLifecycleOwner, {
            if (!it) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.error_city_select),
                    Toast.LENGTH_LONG
                ).show()
            }
        })

        viewBinding.btnSave.setOnClickListener {
            if (LocationCredentials.cityApi != null) {
                LocationCredentials.autoSave = false
                findNavController().setGraph(R.navigation.unsecured_graph)
            }
        }

        viewModel.selectPlace.observe(viewLifecycleOwner, {
            lifecycleScope.launch {
                getPlaceFromId(it.latLng!!.latitude, it.latLng!!.longitude)
            }
        })

        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                viewModel.setPlace(place)
                Log.i("PlaceUI", "Place: ${place.name}, ${place.id}")
            }

            override fun onError(status: Status) {
                viewModel.setSelectionException(status.isSuccess)
                Log.i("Error", "An error occurred: $status")
            }
        })
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    @SuppressLint("MissingPermission")
    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        val request: FindCurrentPlaceRequest = FindCurrentPlaceRequest.newInstance(placeFields)
        val placeResponse = Places.createClient(requireContext()).findCurrentPlace(request)
        placeResponse.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val response = task.result.placeLikelihoods
                val latLng = response[0].place.latLng!!
                val geocoderUi = Geocoder(requireContext(), Locale.getDefault())
                val geocoderApi = Geocoder(requireContext(), Locale.US)
                val addresses: List<Address> = listOf(
                    geocoderUi.getFromLocation(latLng.latitude, latLng.longitude, 1)[0],
                    geocoderApi.getFromLocation(latLng.latitude, latLng.longitude, 1)[0]
                )
                val cityNameUi: String = addresses[0].locality
                val cityNameApi: String = addresses[1].locality
                viewModel.setLocation(cityNameApi, cityNameUi)
                autocompleteFragment.setText(cityNameUi)
                Log.i(
                    TAG,
                    "PlaceUI : $cityNameUi, PlaceApi : $cityNameApi"
                )

            } else {
                val exception = task.exception
                if (exception is ApiException) {
                    Log.e(TAG, "Place not found: ${exception.statusCode}")
                }
            }

        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        Log.e(TAG, "Denied:")
        Toast.makeText(
            requireContext(),
            getString(R.string.please_select_city),
            Toast.LENGTH_LONG
        ).show()
    }

    private fun openPhotoPicker() {
        val permission = Manifest.permission.ACCESS_FINE_LOCATION
        EasyPermissions.requestPermissions(
            this,
            "Locale",
            READ_LOCATION_PERMISSION_REQUEST,
            permission
        )
    }

    private fun getPlaceFromId(latitude: Double, longitude: Double) {
        val geocoderApi = Geocoder(requireContext(), Locale.US)
        val addresses: Address = geocoderApi.getFromLocation(latitude, longitude, 1)[0]
        viewModel.setLocation(addresses.locality, viewModel.selectPlace.value!!.name)

        Log.i("PlaceAPI", "Place found: ${addresses.locality}")

    }
    companion object{
        const val READ_LOCATION_PERMISSION_REQUEST = 123
    }
    }