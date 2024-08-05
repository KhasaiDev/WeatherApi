package com.example.weatherapi.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapi.retrofit.RetrofitClient
import kotlinx.coroutines.launch


class WeatherViewModel:ViewModel() {
    private val _weather = MutableLiveData<Result<WeatherResponse>>()
    val weather: MutableLiveData<Result<WeatherResponse>> get() = _weather

    init {
        fetchWeather()
    }

    private fun fetchWeather() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getWeather()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _weather.value = Result.success(it)
                    } ?: run {
                        _weather.value = Result.failure(Exception("Empty response body"))
                    }
                } else {
                    _weather.value = Result.failure(Exception("Error: ${response.errorBody()?.string()}"))
                }
            } catch (e: Exception) {
                _weather.value = Result.failure(e)
            }
        }
    }
}