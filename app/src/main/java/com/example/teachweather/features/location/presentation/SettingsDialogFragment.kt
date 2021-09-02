//package com.example.teachweather.features.location.presentation
//
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.view.WindowManager
//import android.widget.*
//import androidx.fragment.app.DialogFragment
//import androidx.fragment.app.activityViewModels
//import com.example.teachweather.R
//import com.example.teachweather.databinding.FragmentSettingsDialogBinding
//import android.widget.ArrayAdapter
//import dagger.hilt.android.AndroidEntryPoint
//
//
//@AndroidEntryPoint
//class SettingsDialogFragment : DialogFragment() {
//    private val viewModel: SettingsDialogViewModel by activityViewModels()
//   lateinit var  binding: FragmentSettingsDialogBinding
//    lateinit var spinnerCities: AutoCompleteTextView
//    //lateinit var spinnerCountries: AutoCompleteTextView
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        dialog?.setCanceledOnTouchOutside(true)
//        dialog?.setCancelable(false)
//        return inflater.inflate(R.layout.fragment_settings_dialog, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        var binding = FragmentSettingsDialogBinding.bind(view)
//        viewModel.city.observe(viewLifecycleOwner, {
//           val cities = it as ArrayList<City>
//            val citiesArrayAdapter = ArrayAdapter<City>(
//                requireContext(),
//                android.R.layout.simple_spinner_dropdown_item,
//                it
//            )
//            citiesArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            spinnerCities.setAdapter(citiesArrayAdapter)
//        })
//
//    }
//
//    override fun onStart() {
//        super.onStart()
//        dialog?.window?.setLayout(
//            WindowManager.LayoutParams.MATCH_PARENT,
//            WindowManager.LayoutParams.WRAP_CONTENT
//        )
//
//    }
//
//    companion object {
//        const val TAG = "DialogWithData"
//    }
//
//}