package com.jarredharkness.weather.network

import com.jarredharkness.weather.model.current.WeatherModel
import com.jarredharkness.weather.model.forecast.ForecastModel
import retrofit2.Response

class ApiClient(private val weatherAPI: WeatherAPI) {
    suspend fun getWeather(lat: Double, lon:Double): Response<WeatherModel>{
        return weatherAPI.getWeather(lat, lon)
    }

    suspend fun getForecast(lat: Double, lon:Double): Response<ForecastModel>{
        return weatherAPI.getForecast(lat, lon)
    }
}