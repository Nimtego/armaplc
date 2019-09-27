package com.nimtego.armaplc.presentation.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.nimtego.armaplc.App
import com.nimtego.armaplc.R
import com.nimtego.armaplc.presentation.model.Station
import com.nimtego.armaplc.presentation.view_model.AddStationViewModel
import com.nimtego.armaplc.presentation.view_model.ViewState
import kotlinx.android.synthetic.main.fragment_add_station.*


class AddStationFragment : BaseFragment() {

    private lateinit var addButton: Button
    private lateinit var cancelButton: Button
    private lateinit var pumpNumberPicker: NumberPicker
    private lateinit var stationName: EditText
    private lateinit var phoneNumber: EditText
    private lateinit var stationAddress: EditText
    private lateinit var pumpModel: EditText
    private lateinit var requestInterval: EditText
    private lateinit var pollActiveCheckBox: CheckBox

    private val viewModel: AddStationViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)
            .get(AddStationViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.INSTANCE.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_station, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEditTextFields()
        initPumpNumberPicker()
        initButtons()
        initAddStationEvent()
    }

    private fun initEditTextFields() {
        this.stationName = station_name_edit_text
        this.phoneNumber = station_phone_number_edit_text
        this.stationAddress = station_address_edit_text
        this.pumpModel = station_pump_model_edit_text
        this.requestInterval = station_request_interval_edit_text
    }

    private fun initPumpNumberPicker() {
        this.pumpNumberPicker = pumps_number_picker
        this.pumpNumberPicker.apply {
            maxValue = 3
            minValue = 1
            wrapSelectorWheel = false
        }
    }

    private fun initButtons() {
        this.pollActiveCheckBox = poll_active_check_box
        this.addButton = add_station_button
        this.cancelButton = button_cancel_add_station

        this.addButton.setOnClickListener {
            this.viewModel.addStation(generateStation())
        }
        this.cancelButton.setOnClickListener {
            this.onBackPressed()
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                this@AddStationFragment.onBackPressed()
            }
        })
    }

//    override fun handleOnBackPressed(): Boolean {
//        //Do your job here
//        //use next line if you just need navigate up
//        //NavHostFragment.findNavController(this).navigateUp();
//        //Log.e(getClass().getSimpleName(), "handleOnBackPressed");
//        return true
//    }

    private fun generateStation(): Station {
        //todo take away this
        val checkRequestInterval = this.requestInterval.text.ifEmpty { 0 }.toString().toInt()
        return Station(
            nameStation = this.stationName.text.toString(),
            address = this.stationAddress.text.toString(),
            phoneNumber = this.phoneNumber.text.toString(),
            pumpCount = this.pumpNumberPicker.value,
            requestInterval = checkRequestInterval,
            isPollActive = this.pollActiveCheckBox.isChecked
        )
    }

    private fun onBackPressed() {
        this@AddStationFragment.findNavController().navigateUp()
    }

    private fun initAddStationEvent() {
        this.viewModel.saveStation().observe(this, Observer { event ->
            event.consumeEvent()?.let { viewState ->
                when (viewState.status) {
                    ViewState.Status.SUCCESS -> {
                        Toast.makeText(
                            requireContext(),
                            R.string.station_add, Toast.LENGTH_SHORT
                        ).show()
                        this@AddStationFragment.onBackPressed()
                    }
                    else -> {
                        //todo screen: show required fields
                        Toast.makeText(
                            requireContext(),
                            "${viewState.error?.message}", Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })
        lifecycle.addObserver(this.viewModel)
    }

}
