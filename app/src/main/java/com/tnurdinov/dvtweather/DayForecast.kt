package com.tnurdinov.dvtweather

data class DayForecast(
    val dayName: String,
    val temperature: Int,
    val weatherMain: String,
    val icon: String
)
