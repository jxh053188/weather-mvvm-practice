package com.jarredharkness.weather.ui

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jarredharkness.weather.R
import com.jarredharkness.weather.model.forecast.Daily
import com.jarredharkness.weather.ui.forecast.ForecastFragment
import com.jarredharkness.weather.utils.TimeUtils

class RecyclerViewAdapter(private val forecastList: List<Daily>, private val context: Context): RecyclerView.Adapter<RecyclerViewAdapter.recycleViewHolder>() {

    class recycleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val forecastImage: ImageView = itemView.findViewById(R.id.forecast_image)
        val forecastDate: TextView = itemView.findViewById(R.id.forecast_date)
        val forecastTemp : TextView = itemView.findViewById(R.id.forecast_temp)
        val forecastDescription: TextView = itemView.findViewById(R.id.forecast_condition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recycleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_card, parent, false)
        return recycleViewHolder(itemView)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: recycleViewHolder, position: Int) {
        val currentItem = forecastList[position]
        holder.forecastDate.setText(TimeUtils.getDate(currentItem.dt.toLong()))
        Glide.with(this.context).load("https://openweathermap.org/img/wn/" + currentItem.weather[0].icon + "@2x.png").into(holder.forecastImage)
        holder.forecastDescription.setText(currentItem.weather[0].description)
        holder.forecastTemp.setText(currentItem.temp.max.toInt().toString() + "°C")

    }

    override fun getItemCount(): Int {
       return forecastList.size
    }
}