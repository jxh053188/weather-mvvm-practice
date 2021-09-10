package com.jarredharkness.weather.model.forecast


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Hourly(
    @SerializedName("clouds")
    @Expose
    val clouds: Int,
    @SerializedName("dew_point")
    @Expose
    val dewPoint: Double,
    @SerializedName("dt")
    @Expose
    val dt: Int,
    @SerializedName("feels_like")
    @Expose
    val feelsLike: Double,
    @SerializedName("humidity")
    @Expose
    val humidity: Int,
    @SerializedName("pop")
    @Expose
    val pop: Double,
    @SerializedName("pressure")
    @Expose
    val pressure: Int,
    @SerializedName("rain")
    @Expose
    val rain: Rain,
    @SerializedName("temp")
    @Expose
    val temp: Double,
    @SerializedName("uvi")
    @Expose
    val uvi: Double,
    @SerializedName("visibility")
    @Expose
    val visibility: Int,
    @SerializedName("weather")
    @Expose
    val weather: List<WeatherXX>,
    @SerializedName("wind_deg")
    @Expose
    val windDeg: Int,
    @SerializedName("wind_gust")
    @Expose
    val windGust: Double,
    @SerializedName("wind_speed")
    @Expose
    val windSpeed: Double
)