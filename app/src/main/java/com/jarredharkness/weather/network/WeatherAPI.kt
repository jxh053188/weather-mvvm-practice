package com.jarredharkness.weather.network

import com.jarredharkness.weather.model.WeatherModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    //https://api.openweathermap.org/data/2.5/weather?q=prague&appid=a7c662a3979ffa3d1f15a6a6c66d840f

    @GET("data/2.5/weather?&units=metric&appid=a7c662a3979ffa3d1f15a6a6c66d840f")
    suspend fun getWeather(
        @Query("q") cityName: String
    ): Response<WeatherModel>

}