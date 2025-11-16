package com.tnurdinov.dvtweather
import com.tnurdinov.dvtweather.api.WeatherForecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("forecast")
    suspend fun getFiveDayForeCast(@Query("lat") lat: Double, @Query("lon") lon: Double): Response<WeatherForecast>
}