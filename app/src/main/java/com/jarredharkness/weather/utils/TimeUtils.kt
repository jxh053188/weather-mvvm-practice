package com.jarredharkness.weather.utils

import android.annotation.SuppressLint
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object TimeUtils {
    @SuppressLint("NewApi")
    fun getTime(utcTime: Long): String {
        val formatter = DateTimeFormatter.ofPattern("h:mm a")
        val date: LocalDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(utcTime), ZoneId.systemDefault())
        return date.format(formatter)
    }
}