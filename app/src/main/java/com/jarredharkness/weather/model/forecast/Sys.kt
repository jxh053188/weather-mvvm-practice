package com.jarredharkness.weather.model.forecast


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Sys(
    @SerializedName("pod")
    @Expose
    val pod: String
)