package com.example.weatherapi.models

import android.util.Log
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
                val response = RetrofitClient.instance.getWeather(-33.43107, -70.64666, "fcd51b9342252e2bb7daa90b7f20c2e7")
                if (response.isSuccessful) {
                    response.body()?.let {
                        _weather.value = Result.success(it)
                    } ?: run {
                        _weather.value = Result.failure(Exception("Empty response body"))
                        Log.e("WeatherViewModel", "Empty response body")
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    _weather.value = Result.failure(Exception("Error: $errorBody"))
                    Log.e("WeatherViewModel", "Error: $errorBody")
                }
            } catch (e: Exception) {
                _weather.value = Result.failure(e)
                Log.e("WeatherViewModel", "Exception: ${e.message}")
            }
        }
    }
}