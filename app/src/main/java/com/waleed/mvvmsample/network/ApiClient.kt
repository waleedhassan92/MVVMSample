package com.waleed.mvvmsample.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL: String = "https://reqres.in/"

    lateinit var apiClient: ApiInterface

    fun initialize() {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val client = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        apiClient = retrofit.create(ApiInterface::class.java)
    }
}