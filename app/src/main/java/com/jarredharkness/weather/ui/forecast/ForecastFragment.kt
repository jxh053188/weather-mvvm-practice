package com.jarredharkness.weather.ui.forecast

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jarredharkness.weather.databinding.ForecastFragmentBinding
import com.jarredharkness.weather.ui.mainActivity.MainActivityViewModel
import androidx.fragment.app.activityViewModels

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
        //viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.currentWeatherLiveData.observe(viewLifecycleOwner){response ->
            if (response != null) {
                binding.fragmentTextView.text = response.name
            }
        }
    }

}