package com.jarredharkness.weather.model


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather")
data class WeatherModel(
    @SerializedName("base")
    val base: String,
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("cod")
    val cod: Int,
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("dt")
    val dt: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: Main,
    @SerializedName("name")
    val name: String,
    @SerializedName("sys")
    val sys: Sys,
    @SerializedName("timezone")
    val timezone: Int,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    @Embedded(prefix = "weather_")
    val weather: List<Weather>,
    @SerializedName("wind")
    val wind: Wind
){
    @PrimaryKey
    var weatherId: Int = CURRENT_WEATHER_ID
}