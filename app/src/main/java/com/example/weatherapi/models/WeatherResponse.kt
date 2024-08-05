package com.example.weatherapi.models

import com.google.gson.annotations.SerializedName

data class WeatherResponse (
    val coord: Coord,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Long,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Long,
    val sys: Sys,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Long,
    val rain: Rain? = null
)

data class Clouds (
    val all: Long
)

data class Coord (
    val lon: Double,
    val lat: Double
)

data class Main (
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Long,
    val humidity: Long,
    val seaLevel: Long? = null, // Hacer opcionales estos campos si no siempre están presentes
    val grndLevel: Long? = null
)

data class Rain (
    @SerializedName("1h")
    val oneHour: Double? = null
)

data class Sys (
    val type: Long,
    val id: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)

data class Weather (
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)

data class Wind (
    val speed: Double,
    val deg: Long
)
