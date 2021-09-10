package com.jarredharkness.weather.model.forecast


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Minutely(
    @SerializedName("dt")
    @Expose
    val dt: Int,
    @SerializedName("precipitation")
    @Expose
    val precipitation: Int
)