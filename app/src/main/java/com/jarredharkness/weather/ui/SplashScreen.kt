package com.jarredharkness.weather.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.birjuvachhani.locus.Locus
import com.jarredharkness.weather.R
import com.jarredharkness.weather.ui.mainActivity.MainActivity
import com.jarredharkness.weather.ui.mainActivity.MainActivityViewModel

/**
 * Simple splash screen to start the app.
 */

class SplashScreen : AppCompatActivity() {
    val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()

        val ConnectionManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = ConnectionManager.activeNetworkInfo
            if (networkInfo == null || networkInfo.isConnected != true) {
                Toast.makeText(this@SplashScreen,
                    "Network Not Available. Please check connection and try again.",
                    Toast.LENGTH_LONG).show()

            } else {
                Handler().postDelayed({
                    val intent = Intent(this@SplashScreen, MainActivity::class.java)
                    startActivity(intent)

                }, 3000)
            }
        }
}