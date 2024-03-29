package com.nimtego.armaplc.presentation.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nimtego.armaplc.App
import com.nimtego.armaplc.R
import com.nimtego.armaplc.presentation.ui.widget.StationsListAdapter
import com.nimtego.armaplc.presentation.model.StationsContainer
import com.nimtego.armaplc.presentation.view_model.StationListViewModel
import com.nimtego.armaplc.presentation.model.Station
import com.nimtego.armaplc.presentation.view_model.ViewState
import kotlinx.android.synthetic.main.fragment_station_list.*


class StationListFragment : BaseFragment() {

    private val stationListViewModel: StationListViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)
            .get(StationListViewModel::class.java)
    }

    private lateinit var buttonStation: FloatingActionButton
    private lateinit var listStationsRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        App.INSTANCE.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_station_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        updateStation(StationsContainer(emptyList()))
        initStation()
    }

    private fun initView() {
        this.buttonStation = station_button
        this.buttonStation.setOnClickListener {
            it?.let {
                val navigator = Navigation.findNavController(it)
                navigator.saveState()
                navigator.navigate(R.id.addStationFragment)
            }
        }
        this.listStationsRv = station_list_rv
        this.listStationsRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                this@StationListFragment.context,
                RecyclerView.VERTICAL,
                false
            )
        }

    }

    private fun updateStation(stationModel: StationsContainer?) {
        stationModel?.let {
            this.listStationsRv.adapter = StationsListAdapter(it.stations) {
                stationClick(it)
            }
        }
    }

    private fun stationClick(station: Station) {
        //todo
    }


    private fun initStation() {
        this.stationListViewModel.getState().observe(this, Observer { viewState ->
            viewState.let {
                when (viewState.status) {
                    ViewState.Status.SUCCESS -> updateStation(viewState.data)
                    ViewState.Status.LOADING -> { /* TODO */
                    }
                    ViewState.Status.ERROR ->
                        Toast.makeText(
                            requireContext(),
                            R.string.message_error_load,
                            Toast.LENGTH_SHORT
                        ).show()
                }
            }
        })
        lifecycle.addObserver(stationListViewModel)
    }
}
