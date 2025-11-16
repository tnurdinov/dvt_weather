package com.tnurdinov.dvtweather

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private fun apiKeyAsQuery(chain: Interceptor.Chain) = chain.proceed(
        chain.request()
            .newBuilder()
            .url(chain.request().url.newBuilder().addQueryParameter("appid", BuildConfig.API_KEY).build())
            .build()
    )
    val builder by lazy { OkHttpClient.Builder().addInterceptor { apiKeyAsQuery(it) }.addInterceptor(interceptor) }

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}