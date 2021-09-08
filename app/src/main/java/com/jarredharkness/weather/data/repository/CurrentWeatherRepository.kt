package com.jarredharkness.weather.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jarredharkness.weather.model.WeatherModel
import com.jarredharkness.weather.network.WeatherAPIService

class CurrentWeatherRepository {
    suspend fun getCurrentWeather(cityName: String): WeatherModel? {
        val request = WeatherAPIService.apiClient.getWeather(cityName)

        if(request.isSuccessful){
            return request.body()!!
        }

        return null
    }
}