package com.nimtego.armaplc


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter
import kotlinx.android.synthetic.main.bottom_navigation_fragment.*

class BottomNavigationFragment : Fragment() {

    private lateinit var bottomNavigationView: AHBottomNavigation
    private lateinit var bottomNavController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_navigation_fragment, container, false)
        this.bottomNavController = Navigation.findNavController(view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.bottomNavigationView = bottom_navigation_view
        initBottomNavigation()
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


}
