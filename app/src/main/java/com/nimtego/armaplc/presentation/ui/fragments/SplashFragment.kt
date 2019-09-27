package com.nimtego.armaplc.presentation.ui.fragments


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.nimtego.armaplc.R


class SplashFragment : Fragment() {

    private lateinit var buttonToNavigationFragment: Button

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.navController = NavHostFragment.findNavController(this)
        Handler().postDelayed({
            context?.let {
                findNavController().navigate(R.id.bottomNavigationFragment)
            }
        }, 1500)
    }
}
