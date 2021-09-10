package com.jarredharkness.weather.ui.mainActivity

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.birjuvachhani.locus.Locus
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.tabs.TabLayoutMediator
import com.jarredharkness.weather.R
import com.jarredharkness.weather.databinding.ActivityMainBinding
import com.jarredharkness.weather.ui.FragmentAdapter

class MainActivity : AppCompatActivity() {
    val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Locus.getCurrentLocation(this) { result ->
            result.location?.let {
                val lat = result.location!!.latitude
                val lon = result.location!!.longitude
                viewModel.refreshForecast(lat, lon)
                viewModel.refreshData(lat, lon)
            }
            result.error?.let {
                Toast.makeText(
                    applicationContext,
                    "Unable to get Location. Please check GPS and try again",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

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
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.hamburger_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.about_option -> {
            MaterialAlertDialogBuilder(this )
                .setTitle(resources.getString(R.string.about_option))
                .setMessage(resources.getString(R.string.about_text))
                .setPositiveButton(resources.getString(R.string.ok)) { dialog, which ->
                    // Respond to neutral button press
                }.show()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }

    }
}