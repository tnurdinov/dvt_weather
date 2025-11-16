package com.tnurdinov.dvtweather.repositories

import com.tnurdinov.dvtweather.WeatherService
import com.tnurdinov.dvtweather.api.WeatherForecast
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor() {

    private val weatherService by lazy {
        WeatherService.create()
    }

    suspend fun getWeatherForecast(lat: Double, lon: Double): Response<WeatherForecast> {
        return weatherService.getFiveDayForeCast(lat, lon)
    }
}