package com.jarredharkness.weather.ui.mainActivity

import android.content.ContentValues.TAG
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.jarredharkness.weather.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    //private lateinit var viewmodel: MainActivityViewModel
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

        viewModel.currentWeatherLiveData.observe(this){response ->
            if(response == null){
                Toast.makeText(
                    this@MainActivity,
                    "Network call unsuccessful",
                    Toast.LENGTH_LONG
                ).show()
                return@observe
            }

            binding.cityNameTextView.text = response.name
            binding.weatherDescriptionTextview.text = response.weather.get(0).description
            binding.tvDegree.text = response.main.temp.toInt().toString() + "°C"
            binding.windSpeedTextView.text = response.wind.speed.toInt().toString() + " km/h"
            binding.pressureTextView.text = response.main.pressure.toString() + " hPa"
            //binding.sunRiseTextView.text = response.sys.sunrise.toString()

            Glide.with(this)
                    .load("https://openweathermap.org/img/wn/" + response.weather.get(0).icon + "@2x.png")
                    .into(binding.imgWeatherPictures)
        }
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

//    private fun getLiveData() {
//
//        viewmodel.weather_data.observe(this, Observer { data ->
//            data?.let {
//
//                binding.weatherDescriptionTextview.text = data.weather.get(0).description
//                binding.cityNameTextView.text = data.name
//
//                Glide.with(this)
//                    .load("https://openweathermap.org/img/wn/" + data.weather.get(0).icon + "@2x.png")
//                    .into(binding.imgWeatherPictures)
//
//                binding.tvDegree.text = data.main.temp.toInt().toString() + "°C"
////                binding.tvHumidity.text = data.main.humidity.toString() + "%"
////                binding.tvWindSpeed.text = data.wind.speed.toString()
////                binding.tvLat.text = data.coord.lat.toString()
////                binding.tvLon.text = data.coord.lon.toString()
//
//            }
//        })
//
//        viewmodel.weather_error.observe(this, Observer { error ->
//            error?.let {
//                if (error) {
//                    binding.tvError.visibility = View.VISIBLE
//                    binding.pbLoading.visibility = View.GONE
//                } else {
//                    binding.tvError.visibility = View.GONE
//                }
//            }
//        })
//
//        viewmodel.weather_loading.observe(this, Observer { loading ->
//            loading?.let {
//                if (loading) {
//                    binding.pbLoading.visibility = View.VISIBLE
//                    binding.tvError.visibility = View.GONE
//                } else {
//                    binding.pbLoading.visibility = View.GONE
//                }
//            }
//        })
//
//    }

}