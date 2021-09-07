package com.jarredharkness.weather.data.repository

import androidx.lifecycle.MutableLiveData
import com.jarredharkness.weather.model.WeatherModel

interface CurrentWeatherRepository {
    suspend fun getCurrentWeather(cityName: String): MutableLiveData<WeatherModel>
}