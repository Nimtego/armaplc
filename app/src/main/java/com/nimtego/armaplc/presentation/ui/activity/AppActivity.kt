package com.nimtego.armaplc.presentation.ui.activity

import android.Manifest
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.nimtego.armaplc.R
import com.nimtego.armaplc.presentation.receivers.SmsBroadcastReceiver


class AppActivity : AppCompatActivity() {

    private lateinit var appController: NavController
    private val MY_PERMISSIONS_REQUEST_SMS_RECEIVE = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.appController = Navigation.findNavController(this, R.id.app_nav_host_fragment)
        val extras = intent.extras
        if (extras != null) {
            val address = extras.getString("address")
            val message = extras.getString("message")
            Toast.makeText(this, "$address $message",Toast.LENGTH_SHORT).show()
        }

        ActivityCompat.requestPermissions(this,
             arrayOf(Manifest.permission.RECEIVE_SMS),
            MY_PERMISSIONS_REQUEST_SMS_RECEIVE)
//        this.appController.navigate(R.id.splashFragment, null,
//            NavOptions.Builder().setPopUpTo(R.id.splashFragment, true).build())


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_PERMISSIONS_REQUEST_SMS_RECEIVE) {
            // YES!!
            Log.i("TAG", "MY_PERMISSIONS_REQUEST_SMS_RECEIVE --> YES")
        }
    }

}
