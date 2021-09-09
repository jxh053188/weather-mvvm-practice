package com.jarredharkness.weather.ui.mainActivity

import android.content.ContentValues.TAG
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.jarredharkness.weather.databinding.ActivityMainBinding
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

        bindUI()

        var cityName = GET.getString("cityName", "London")
        binding.edtCityName.setText(cityName)
        viewModel.refreshData(cityName!!)

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.tvError.visibility = View.GONE
            binding.pbLoading.visibility = View.GONE

            var cityName = GET.getString("cityName", cityName)?.lowercase()
            binding.edtCityName.setText(cityName)
            viewModel.refreshData(cityName!!)
            binding.swipeRefreshLayout.isRefreshing = false
        }

        binding.edtCityName.setOnClickListener {
            val cityName = binding.edtCityName.text.toString()
            SET.putString("cityName", cityName)
            SET.apply()
            viewModel.refreshData(cityName)
            Log.i(TAG, "onCreate: " + cityName)
        }

    }

    fun bindUI() {
        viewModel.currentWeatherLiveData.observe(this){response ->
            if(response == null){
                Toast.makeText(
                    this@MainActivity,
                    "Network call unsuccessful",
                    Toast.LENGTH_LONG
                ).show()
                return@observe
            }

            var time = TimeUtils.getTime(response.sys.sunrise.toLong())
            val rainMM: String = if(response.rain == null){
                "0.0"
            } else {
                response.rain.h.toString()
            }

            binding.sunRiseTextView.text = time
            binding.cityNameTextView.text = response.name
            binding.weatherDescriptionTextview.text = response.weather.get(0).description
            (response.main.temp.toInt().toString() + "°C").also { binding.tvDegree.text = it }
            (response.wind.speed.toInt().toString() + " km/h").also { binding.windSpeedTextView.text = it }
            (response.main.pressure.toString() + " hPa").also { binding.pressureTextView.text = it }
            (response.wind.deg.toString() + "°").also { binding.windDirectionTextView.text = it }
            (response.clouds.all.toString() + "%").also { binding.rainTextview.text = it }
            (rainMM + "mm").also { binding.precipitationTextView.text = it }

            Glide.with(this)
                .load("https://openweathermap.org/img/wn/" + response.weather.get(0).icon + "@2x.png")
                .into(binding.imgWeatherPictures)
        }

    }


}