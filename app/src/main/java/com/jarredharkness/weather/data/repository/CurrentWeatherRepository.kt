package com.jarredharkness.weather.data.repository

import com.jarredharkness.weather.model.current.WeatherModel
import com.jarredharkness.weather.model.forecast.ForecastModel
import com.jarredharkness.weather.network.WeatherAPIService



class CurrentWeatherRepository {
    suspend fun getCurrentWeather(lat: Double, lon: Double): WeatherModel? {
        val request = WeatherAPIService.apiClient.getWeather(lat, lon)

        if(request.isSuccessful){
            return request.body()!!
        }

        return null
    }

    suspend fun getForecast(lat: Double, lon:Double): ForecastModel? {
        val request = WeatherAPIService.apiClient.getForecast(lat, lon)
        //Check if device has internet connection
        if(request.isSuccessful){
            println(request.body())
            return request.body()!!
        }else{
            println("not successful")
        }
        return null
    }
}