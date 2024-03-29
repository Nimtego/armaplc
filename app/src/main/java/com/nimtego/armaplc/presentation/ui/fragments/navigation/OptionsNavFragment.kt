package com.nimtego.armaplc.presentation.ui.fragments.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.nimtego.armaplc.R
import com.nimtego.armaplc.presentation.ui.fragments.BackButtonListener

class OptionsNavFragment : Fragment(), BackButtonListener {

    private lateinit var optionsNavController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.nav_options_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.optionsNavController = Navigation.findNavController(view.findViewById(R.id.options_nav_host_fragment))
    }

    override fun onBackPressed() {
        this.optionsNavController.popBackStack()
    }
}
