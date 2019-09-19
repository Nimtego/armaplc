package com.nimtego.armaplc.presentation.fragments.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.nimtego.armaplc.R
import com.nimtego.armaplc.presentation.fragments.BackButtonListener

class StationsNavFragment: Fragment(), BackButtonListener {


    private lateinit var bottomNavController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.nav_stations_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //this.bottomNavController = Navigation.findNavController(view)
        this.bottomNavController = Navigation.findNavController(view.findViewById(R.id.stations_list_nav_host_fragment))
        this.bottomNavController.navigate(R.id.stationListFragment)
    }

    override fun onBackPressed() {
        this.bottomNavController.popBackStack()
    }
}
