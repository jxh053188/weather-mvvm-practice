package com.jarredharkness.weather.model.forecast


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Wind(
    @SerializedName("deg")
    @Expose
    val deg: Int,
    @SerializedName("gust")
    @Expose
    val gust: Double,
    @SerializedName("speed")
    @Expose
    val speed: Double
)