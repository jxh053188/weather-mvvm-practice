package com.jarredharkness.weather.model.forecast


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ForecastModel(
    @SerializedName("city")
    @Expose
    val city: City,
    @SerializedName("cnt")
    @Expose
    val cnt: Int,
    @SerializedName("cod")
    @Expose
    val cod: String,
    @SerializedName("list")
    @Expose
    val list: List<ForecastList>,
    @SerializedName("message")
    @Expose
    val message: Int
)