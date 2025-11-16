package com.tnurdinov.dvtweather

object WeatherIcons {
    private val iconMap = mapOf(
        "01d" to R.drawable.ic_01,
        "01n" to R.drawable.ic_01,
        "02d" to R.drawable.ic_02,
        "02n" to R.drawable.ic_02,
        "03d" to R.drawable.ic_03,
        "03n" to R.drawable.ic_03,
        "04d" to R.drawable.ic_04,
        "04n" to R.drawable.ic_04,
        "09d" to R.drawable.ic_09,
        "09n" to R.drawable.ic_09,
        "10d" to R.drawable.ic_10,
        "10n" to R.drawable.ic_10,
        "11d" to R.drawable.ic_11,
        "11n" to R.drawable.ic_11,
        "13d" to R.drawable.ic_13,
        "13n" to R.drawable.ic_13,
        "50d" to R.drawable.ic_50,
        "50n" to R.drawable.ic_50
    )

    fun getIcon(iconCode: String): Int {
        return iconMap[iconCode] ?: R.drawable.ic_01
    }
}