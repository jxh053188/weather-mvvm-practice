package com.jarredharkness.weather.ui.forecast


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jarredharkness.weather.databinding.ForecastFragmentBinding
import com.jarredharkness.weather.ui.mainActivity.MainActivityViewModel
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.jarredharkness.weather.model.forecast.Daily
import com.jarredharkness.weather.model.forecast.ForecastModel
import com.jarredharkness.weather.ui.RecyclerViewAdapter

class ForecastFragment : Fragment() {

    private lateinit var _binding: ForecastFragmentBinding
    val binding get() = _binding

    private val viewModel : MainActivityViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ForecastFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.forecastLiveData.observe(this){forecastResponse ->
            if (forecastResponse == null) {
                return@observe
            }
            val recyclerViewListItems: List<Daily> = forecastResponse.daily
            binding.recyclerCard.adapter = RecyclerViewAdapter(recyclerViewListItems)
            binding.recyclerCard.layoutManager = LinearLayoutManager(context)
            binding.recyclerCard.setHasFixedSize(true)
        }

    }

}