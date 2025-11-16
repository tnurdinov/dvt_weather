package com.tnurdinov.dvtweather.repositories

import com.tnurdinov.dvtweather.WeatherService
import com.tnurdinov.dvtweather.api.WeatherForecast
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor() {

    private val weatherService by lazy {
        WeatherService.create()
    }

    suspend fun getWeatherForecast(): Response<WeatherForecast>? {
        return try {
            weatherService.getFiveDayForeCast(25.2048, 55.2708)
        } catch (e: Exception) {
            null
        }
    }
}