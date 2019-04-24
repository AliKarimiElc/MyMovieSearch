package com.example.mymoviesearch.repository.remote

import com.example.mymoviesearch.Consts
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServiceGenerator {
    private val apiBaseUrl = Consts.baseURL

    private val httpClient = OkHttpClient.Builder().build()
    private val builder = Retrofit.Builder()
        .baseUrl(apiBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {
        val retrofit = builder.client(httpClient).build()
        return retrofit.create(serviceClass)
    }
}