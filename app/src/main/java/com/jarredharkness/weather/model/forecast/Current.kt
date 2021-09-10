package com.jarredharkness.weather.model.forecast


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Current(
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
    @SerializedName("pressure")
    @Expose
    val pressure: Int,
    @SerializedName("sunrise")
    @Expose
    val sunrise: Int,
    @SerializedName("sunset")
    @Expose
    val sunset: Int,
    @SerializedName("temp")
    @Expose
    val temp: Double,
    @SerializedName("uvi")
    @Expose
    val uvi: Int,
    @SerializedName("visibility")
    @Expose
    val visibility: Int,
    @SerializedName("weather")
    @Expose
    val weather: List<Weather>,
    @SerializedName("wind_deg")
    @Expose
    val windDeg: Int,
    @SerializedName("wind_speed")
    @Expose
    val windSpeed: Double
)