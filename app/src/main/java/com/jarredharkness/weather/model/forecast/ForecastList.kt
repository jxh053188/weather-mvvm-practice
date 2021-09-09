package com.jarredharkness.weather.model.forecast


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ForecastList(
    @SerializedName("clouds")
    @Expose
    val clouds: Clouds,
    @SerializedName("dt")
    @Expose
    val dt: Int,
    @SerializedName("dt_txt")
    @Expose
    val dtTxt: String,
    @SerializedName("main")
    @Expose
    val main: Main,
    @SerializedName("pop")
    @Expose
    val pop: Double,
    @SerializedName("rain")
    @Expose
    val rain: Rain,
    @SerializedName("sys")
    @Expose
    val sys: Sys,
    @SerializedName("visibility")
    @Expose
    val visibility: Int,
    @SerializedName("weather")
    @Expose
    val weather: List<Weather>,
    @SerializedName("wind")
    @Expose
    val wind: Wind
)