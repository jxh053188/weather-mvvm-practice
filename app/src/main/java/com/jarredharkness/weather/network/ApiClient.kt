package com.jarredharkness.weather.network

import com.jarredharkness.weather.model.current.WeatherModel
import com.jarredharkness.weather.model.forecast.ForecastModel
import retrofit2.Response

class ApiClient(private val weatherAPI: WeatherAPI) {

    suspend fun getWeather(lat: Double, lon: Double): SimpleResponse<WeatherModel>{
        return safeApiCall {weatherAPI.getWeather(lat, lon)}
    }

    suspend fun getForecast(lat: Double, lon: Double): SimpleResponse<ForecastModel>{
        return safeApiCall { weatherAPI.getForecast(lat, lon) }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T>{
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch(e: Exception) {
            SimpleResponse.failure(e)
        }
    }
}