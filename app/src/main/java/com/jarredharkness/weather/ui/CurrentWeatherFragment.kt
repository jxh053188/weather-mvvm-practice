package com.jarredharkness.weather.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.jarredharkness.weather.databinding.CurrentWeatherFragmentBinding
import com.jarredharkness.weather.ui.mainActivity.MainActivityViewModel
import com.jarredharkness.weather.utils.TimeUtils

class CurrentWeatherFragment : Fragment() {

    private lateinit var _binding: CurrentWeatherFragmentBinding
    val binding get() = _binding
    private val viewModel : MainActivityViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CurrentWeatherFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.currentWeatherLiveData.observe(viewLifecycleOwner){response ->
            if(response == null){
                Toast.makeText(
                    context,
                    "Network call unsuccessful",
                    Toast.LENGTH_LONG
                ).show()
                return@observe
            }

            val time = TimeUtils.getTime(response.sys.sunrise.toLong())
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