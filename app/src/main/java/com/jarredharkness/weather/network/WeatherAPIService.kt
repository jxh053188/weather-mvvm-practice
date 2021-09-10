package com.jarredharkness.weather.network

import com.jarredharkness.weather.model.current.WeatherModel
import com.jarredharkness.weather.model.forecast.ForecastModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jarredharkness.weather.utils.Constants
import retrofit2.Response
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object WeatherAPIService {
    private val api = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(WeatherAPI::class.java)


    val apiClient = ApiClient(api)

    suspend fun getDataService(lat: Double, lon:Double): Response<WeatherModel> {
        return api.getWeather(lat, lon)
    }

    suspend fun getForecastService(lat: Double, lon:Double): Response<ForecastModel> {
        return api.getForecast(lat, lon)
    }
}