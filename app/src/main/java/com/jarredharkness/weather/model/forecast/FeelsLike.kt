package com.jarredharkness.weather.model.forecast


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class FeelsLike(
    @SerializedName("day")
    @Expose
    val day: Double,
    @SerializedName("eve")
    @Expose
    val eve: Double,
    @SerializedName("morn")
    @Expose
    val morn: Double,
    @SerializedName("night")
    @Expose
    val night: Double
)