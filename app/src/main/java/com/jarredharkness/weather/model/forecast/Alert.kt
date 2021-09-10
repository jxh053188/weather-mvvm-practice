package com.jarredharkness.weather.model.forecast


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Alert(
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("end")
    @Expose
    val end: Int,
    @SerializedName("event")
    @Expose
    val event: String,
    @SerializedName("sender_name")
    @Expose
    val senderName: String,
    @SerializedName("start")
    @Expose
    val start: Int,
    @SerializedName("tags")
    @Expose
    val tags: List<String>
)