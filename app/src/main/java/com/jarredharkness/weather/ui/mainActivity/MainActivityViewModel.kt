package com.jarredharkness.weather.ui.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarredharkness.weather.data.repository.CurrentWeatherRepository
import com.jarredharkness.weather.model.current.WeatherModel
import com.jarredharkness.weather.model.forecast.ForecastModel
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    private val repository = CurrentWeatherRepository()

    private val _currentWeatherLiveData = MutableLiveData<WeatherModel?>()
    val currentWeatherLiveData: LiveData<WeatherModel?> = _currentWeatherLiveData

    private val _forecastLiveData = MutableLiveData<ForecastModel?>()
    val forecastLiveData: LiveData<ForecastModel?> = _forecastLiveData

    fun refreshData(lat: Double, lon:Double) {
        viewModelScope.launch {
            val response = repository.getCurrentWeather(lat, lon)
            _currentWeatherLiveData.postValue(response)
        }
    }
    fun refreshForecast(lat: Double, lon:Double){
        viewModelScope.launch {
            val forecastResponse = repository.getForecast(lat,lon)
            _forecastLiveData.postValue(forecastResponse)

        }
    }
}