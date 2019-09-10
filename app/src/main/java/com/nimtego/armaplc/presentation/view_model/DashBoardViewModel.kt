package com.nimtego.armaplc.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData

class DashBoardViewModel : ViewModel() {
    var data: MutableLiveData<String>? = null

    fun getData(): LiveData<String> {
        if (data == null) {
            data = MutableLiveData()
            loadData()
        }
        return data as MutableLiveData<String>
    }

    private fun loadData() {
//        dataRepository.loadData(object : Callback<String>() {
//            fun onLoad(s: String) {
//                data.postValue(s)
//            }
//        })
    }
}