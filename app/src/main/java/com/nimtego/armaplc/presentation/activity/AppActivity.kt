package com.nimtego.armaplc.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.nimtego.armaplc.R

class AppActivity : AppCompatActivity() {

    private lateinit var appController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.appController = Navigation.findNavController(this, R.id.app_nav_host_fragment)
        this.appController.navigate(R.id.splashFragment)
    }
}
