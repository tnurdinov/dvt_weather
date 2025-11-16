package com.tnurdinov.dvtweather.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tnurdinov.dvtweather.api.WeatherForecast
import com.tnurdinov.dvtweather.repositories.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val _weatherResponse = mutableStateOf<WeatherForecast>(WeatherForecast())
    val weatherResponse: State<WeatherForecast> = _weatherResponse

    init {
        getWeatherForeCast()
    }

    private fun getWeatherForeCast() {
        viewModelScope.launch {
            _weatherResponse.value = weatherRepository.getWeatherForecast()!!.body()!!
        }
    }

}