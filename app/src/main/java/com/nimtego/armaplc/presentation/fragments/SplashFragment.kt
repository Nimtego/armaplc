package com.nimtego.armaplc.presentation.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.nimtego.armaplc.R
import kotlinx.android.synthetic.main.fragment_splash.*


class SplashFragment : Fragment() {

    private lateinit var buttonToNavigationFragment: Button

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.buttonToNavigationFragment = button_to_bottom_navigation
        this.navController = NavHostFragment.findNavController(this)
        this.buttonToNavigationFragment.setOnClickListener {
            navController.navigate(R.id.bottom_bar_nav_graph)
        }
    }


}
