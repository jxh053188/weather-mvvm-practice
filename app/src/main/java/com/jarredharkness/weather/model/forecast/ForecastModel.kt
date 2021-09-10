package com.jarredharkness.weather.model.forecast


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ForecastModel(
    @SerializedName("alerts")
    @Expose
    val alerts: List<Alert>,
    @SerializedName("current")
    @Expose
    val current: Current,
    @SerializedName("daily")
    @Expose
    val daily: List<Daily>,
    @SerializedName("hourly")
    @Expose
    val hourly: List<Hourly>,
    @SerializedName("lat")
    @Expose
    val lat: Double,
    @SerializedName("lon")
    @Expose
    val lon: Double,
    @SerializedName("minutely")
    @Expose
    val minutely: List<Minutely>,
    @SerializedName("timezone")
    @Expose
    val timezone: String,
    @SerializedName("timezone_offset")
    @Expose
    val timezoneOffset: Int
)