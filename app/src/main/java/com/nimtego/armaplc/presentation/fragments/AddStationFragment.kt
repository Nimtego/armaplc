package com.nimtego.armaplc.presentation.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.nimtego.armaplc.R
import com.nimtego.armaplc.presentation.view_model.AddStationViewModel
import com.nimtego.armaplc.presentation.view_model.StationViewModel
import com.nimtego.armaplc.presentation.view_model.ViewState
import kotlinx.android.synthetic.main.fragment_add_station.*
import kotlin.random.Random

class AddStationFragment : BaseFragment() {

    private lateinit var addButton: Button

    private val viewModel: AddStationViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)
            .get(AddStationViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_station, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.addButton = add_station_button
        this.addButton.setOnClickListener {
            this.viewModel.addStation(
                StationViewModel(
                    nameStation = "Test name ${Random(100)}",
                    address = "Test ${Random(100)}",
                    phoneNumber = "+7 890 ${Random(100)}",
                    isPollActive = "Test"
                )
            )
        }
        initAddStationEvent()
    }

    fun initAddStationEvent() {
        this.viewModel.saveStation().observe(this, Observer { event ->
            event.consumeEvent()?.let { viewState ->
                when (viewState.status) {
                    ViewState.Status.SUCCESS -> {
                        Toast.makeText(
                            requireContext(),
                            R.string.station_add, Toast.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        Toast.makeText(
                            requireContext(),
                            R.string.message_error_load, Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })
        lifecycle.addObserver(this.viewModel)
    }

}
