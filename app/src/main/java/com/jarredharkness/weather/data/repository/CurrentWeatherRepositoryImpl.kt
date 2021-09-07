package com.jarredharkness.weather.data.repository

import androidx.lifecycle.MutableLiveData
import com.jarredharkness.weather.model.WeatherModel

class CurrentWeatherRepositoryImpl : CurrentWeatherRepository {

    override suspend fun getCurrentWeather(cityName: String): MutableLiveData<WeatherModel> {
        TODO("Not yet implemented")
    }
}