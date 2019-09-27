package com.nimtego.armaplc.presentation.ui.fragments

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class BaseFragment : Fragment() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

}
