package com.nimtego.armaplc.presentation.fragments.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.nimtego.armaplc.R
import com.nimtego.armaplc.presentation.fragments.BackButtonListener

class DashBoardNavFragment : Fragment(), BackButtonListener {

    private lateinit var dashBoardNavController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.nav_dash_board_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.dashBoardNavController = Navigation.findNavController(view.findViewById(R.id.dash_board_nav_host_fragment))
    }

    override fun onBackPressed() {
        this.dashBoardNavController.popBackStack()
    }
}
