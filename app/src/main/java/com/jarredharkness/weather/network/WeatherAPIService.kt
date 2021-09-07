package com.jarredharkness.weather.network

import android.provider.SyncStateContract
import com.jarredharkness.weather.model.WeatherModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jarredharkness.weather.utils.Constants
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class WeatherAPIService {
    private val api = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(WeatherAPI::class.java)

    fun getDataService(cityName: String): Single<WeatherModel> {
        return api.getData(cityName)
    }
}