package com.example.weatherapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapi.models.WeatherResponse
import com.google.android.material.textview.MaterialTextView

class WeatherAdapter(private var weathers:List<WeatherResponse>)
    : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {
    inner class WeatherViewHolder(view: View): RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return WeatherViewHolder(view)
    }
    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val recipe = weathers[position]

    }

    override fun getItemCount(): Int {
        return weathers.size
    }
}