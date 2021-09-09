package com.jarredharkness.weather.data.repository

import com.jarredharkness.weather.model.current.WeatherModel
import com.jarredharkness.weather.model.forecast.ForecastModel
import com.jarredharkness.weather.network.WeatherAPIService

class CurrentWeatherRepository {
    suspend fun getCurrentWeather(cityName: String): WeatherModel? {
        val request = WeatherAPIService.apiClient.getWeather(cityName)

        if(request.isSuccessful){
            return request.body()!!
        }

        return null
    }

    suspend fun getForecast(cityName:String): ForecastModel? {
        val request = WeatherAPIService.apiClient.getForecast(cityName)
        //Check if device has internet connection
        if(request.isSuccessful){
            return request.body()!!
        }

        return null
    }
}