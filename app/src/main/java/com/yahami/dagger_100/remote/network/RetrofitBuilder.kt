package com.yahami.dagger_100.remote.network

import com.google.gson.Gson
import com.yahami.dagger_100.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val retrofit: Retrofit by lazy { buildRetrofit() }

private fun buildRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .client(createHttpClient())
        .addConverters()
        .build()

fun createHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(prepareLoggingInterceptor())
        .build()

private fun Retrofit.Builder.addConverters(): Retrofit.Builder = this
        .addConverterFactory(GsonConverterFactory.create(Gson()))  // convert data with Gson/JSON
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // allow RxJava2 types (Observable, Single)


/**
 * Logging Interceptor
 */
private fun prepareLoggingInterceptor() = HttpLoggingInterceptor().apply {
    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
    else HttpLoggingInterceptor.Level.NONE
}