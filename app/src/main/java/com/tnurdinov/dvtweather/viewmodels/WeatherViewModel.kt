package com.tnurdinov.dvtweather.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tnurdinov.dvtweather.DayForecast
import com.tnurdinov.dvtweather.api.WeatherForecast
import com.tnurdinov.dvtweather.repositories.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepository: WeatherRepository) : ViewModel() {

    private val _weatherResponse = mutableStateOf<List<DayForecast>>(emptyList<DayForecast>())
    val weatherResponse: State<List<DayForecast>> = _weatherResponse

    init {
        getWeatherForeCast()
    }

    private fun getWeatherForeCast() {
        viewModelScope.launch {

            val weatherForecast = weatherRepository.getWeatherForecast().body()
            val fiveDayForecast = get5DayForecast(weatherForecast!!)

            _weatherResponse.value = fiveDayForecast
        }
    }

    fun get5DayForecast(weatherForecast: WeatherForecast): List<DayForecast> {
        val list = weatherForecast.list

        val dailyForecasts = mutableMapOf<String, DayForecast>()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())

        for (item in list) {
            val dtTxt = item.dtTxt
            val date = dateFormat.parse(dtTxt?.split(" ")[0])
            val dayKey = dateFormat.format(date!!)

            val time = dtTxt?.split(" ")[1]
            if ((time == NOON_TIME) && !dailyForecasts.containsKey(dayKey)) {
                val weather = item.weather[0]

                dailyForecasts[dayKey] = DayForecast(
                    dayName = dayFormat.format(date),
                    temperature = (item.main?.temp ?: 0.0).toInt(),
                    weatherMain = weather.main ?: "",
                    icon = weather.icon ?: ""
                )
            }

            if (dailyForecasts.size >= 5) break
        }

        return dailyForecasts.values.toList()
    }

    companion object {
        const val NOON_TIME = "12:00:00"
    }
}