package com.jarredharkness.weather.ui.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarredharkness.weather.data.repository.CurrentWeatherRepository
import com.jarredharkness.weather.model.current.WeatherModel
import com.jarredharkness.weather.model.forecast.ForecastModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    private val repository = CurrentWeatherRepository()

    private val _currentWeatherLiveData = MutableLiveData<WeatherModel?>()
    val currentWeatherLiveData: LiveData<WeatherModel?> = _currentWeatherLiveData

    private val _forecastLiveData = MutableLiveData<ForecastModel?>()
    val forecastLiveData: LiveData<ForecastModel?> = _forecastLiveData

    fun refreshData(cityName: String) {
        //getDataFromAPI(cityName)
        viewModelScope.launch {
            val response = repository.getCurrentWeather(cityName)
            _currentWeatherLiveData.postValue(response)
        }
    }

    fun refreshForecast(cityName: String){
        viewModelScope.launch {
            val forecastResponse = repository.getForecast(cityName)

        }
    }
}