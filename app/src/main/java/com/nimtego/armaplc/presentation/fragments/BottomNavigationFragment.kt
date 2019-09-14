package com.nimtego.armaplc.presentation.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter
import com.nimtego.armaplc.R
import kotlinx.android.synthetic.main.bottom_navigation_fragment.*

class BottomNavigationFragment : Fragment(), BackButtonListener {

    private lateinit var bottomNavigationView: AHBottomNavigation
    private lateinit var bottomNavController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_navigation_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //this.bottomNavController = Navigation.findNavController(view)
        this.bottomNavController = Navigation.findNavController(view.findViewById(R.id.bottom_bar_nav_host_fragment))
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.bottomNavigationView = bottom_navigation_view
        initBottomNavigation()
        this.bottomNavController.navigate(R.id.dashBoardFragment)
    }

    private fun initBottomNavigation() {
        AHBottomNavigationAdapter(activity, R.menu.bottom_navigation_menu).apply {
            setupWithBottomNavigation(bottomNavigationView)

        }
        with(bottomNavigationView) {
            this.accentColor = context.getColor(R.color.color_navigation_item_active)
            this.inactiveColor = context.getColor(R.color.color_navigation_item_inactive)

            this.setOnTabSelectedListener { position, wasSelected ->
                if (!wasSelected) selectTab(position)
                true
            }
        }

        this.bottomNavigationView.isBehaviorTranslationEnabled = false
    }

    private fun selectTab(number: Int) {
        when (number) {
            0 -> bottomNavController.navigate(R.id.dashBoardFragment)
            1 -> bottomNavController.navigate(R.id.stationListFragment)
            2 -> bottomNavController.navigate(R.id.settingsFragment)
        }

    }

    override fun onBackPressed() {
        this.bottomNavController.popBackStack()
    }
}
