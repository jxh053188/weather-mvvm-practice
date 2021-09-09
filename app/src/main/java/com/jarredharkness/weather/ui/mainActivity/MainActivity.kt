package com.jarredharkness.weather.ui.mainActivity

import android.content.ContentValues.TAG
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.jarredharkness.weather.R
import com.jarredharkness.weather.databinding.ActivityMainBinding
import com.jarredharkness.weather.ui.FragmentAdapter
import com.jarredharkness.weather.ui.forecast.ForecastFragment
import com.jarredharkness.weather.utils.TimeUtils

class MainActivity : AppCompatActivity() {
    val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    private lateinit var GET: SharedPreferences
    private lateinit var SET: SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        GET = getSharedPreferences(packageName, MODE_PRIVATE)
        SET = GET.edit()

        val tableLayout = binding.tabLayout
        val viewPager2 = binding.viewPager
        val adapter = FragmentAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        TabLayoutMediator(tableLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Current Weather"
                }
                1 -> {
                    tab.text = "Forecast"
                }
            }
        }.attach()
    }
}