package com.jarredharkness.weather.ui.mainActivity

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.jarredharkness.weather.R
import com.jarredharkness.weather.databinding.ActivityMainBinding
import com.jarredharkness.weather.ui.FragmentAdapter

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

        viewModel.refreshData("Prague")

        val tableLayout = binding.tabLayout
        val viewPager2 = binding.viewPager
        val adapter = FragmentAdapter(supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        TabLayoutMediator(tableLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Today"
                    tab.setIcon(R.drawable.ic_today)
                }
                1 -> {
                    tab.text = "Forecast"
                    tab.setIcon(R.drawable.ic_forecast)
                }
            }
        }.attach()
    }
}