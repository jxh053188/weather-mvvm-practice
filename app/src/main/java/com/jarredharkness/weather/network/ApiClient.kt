package com.jarredharkness.weather.network

import com.jarredharkness.weather.model.current.WeatherModel
import retrofit2.Response

class ApiClient(private val weatherAPI: WeatherAPI) {
    suspend fun getWeather(cityName: String): Response<WeatherModel>{
        return weatherAPI.getWeather(cityName)
    }
}