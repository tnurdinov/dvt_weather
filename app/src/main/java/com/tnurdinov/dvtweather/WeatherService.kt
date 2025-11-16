package com.tnurdinov.dvtweather
import com.tnurdinov.dvtweather.api.WeatherForecast
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("forecast")
    suspend fun getFiveDayForeCast(@Query("lat") lat: Double, @Query("lon") lon: Double): Response<WeatherForecast>

    companion object {

        private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        private fun apiKeyAsQuery(chain: Interceptor.Chain) = chain.proceed(
            chain.request()
                .newBuilder()
                .url(chain.request().url.newBuilder().addQueryParameter("appid", BuildConfig.API_KEY).build())
                .build()
        )
        val builder by lazy { OkHttpClient.Builder().addInterceptor { apiKeyAsQuery(it) }.addInterceptor(interceptor) }

        fun create(): WeatherService {

            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(WeatherService::class.java)
        }
    }
}