package com.jarredharkness.weather.network

import com.jarredharkness.weather.model.current.WeatherModel
import com.jarredharkness.weather.model.forecast.ForecastModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    //https://api.openweathermap.org/data/2.5/weather?q=prague&appid=a7c662a3979ffa3d1f15a6a6c66d840f

    @GET("data/2.5/weather?&units=metric&appid=a7c662a3979ffa3d1f15a6a6c66d840f")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Response<WeatherModel>

    @GET("data/2.5/onecall?&units=metric&appid=a7c662a3979ffa3d1f15a6a6c66d840f")
    suspend fun getForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Response<ForecastModel>

}