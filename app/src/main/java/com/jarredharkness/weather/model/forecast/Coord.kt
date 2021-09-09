package com.jarredharkness.weather.model.forecast


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Coord(
    @SerializedName("lat")
    @Expose
    val lat: Double,
    @SerializedName("lon")
    @Expose
    val lon: Double
)