package com.nimtego.armaplc.presentation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.nimtego.armaplc.R
import kotlinx.android.synthetic.main.fragment_station_list.*


class StationListFragment : Fragment() {

    private lateinit var buttonStation: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_station_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.buttonStation = station_button
        this.buttonStation.setOnClickListener {
            it?.let { Navigation.findNavController(it).navigate(R.id.addStationFragment) }
        }
    }


}
