package com.example.weatherapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.weatherapi.databinding.FragmentWeatherBinding
import com.example.weatherapi.models.WeatherViewModel

class WeatherFragment : Fragment() {
    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!
    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =  FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherViewModel.weather.observe(viewLifecycleOwner, Observer{ result ->
            result.fold(
                onSuccess = {
                    Log.e("WeatherFragment", "Result ${it.cod}")

                },
                onFailure = {
                    // Handle error
                    Log.e("RecipeFragment", "Error: ${it.message}")
                }
            )
        })
    }

}