package com.waleed.mvvmsample.network

import com.waleed.mvvmsample.models.Page
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("api/users")
    fun getUsers(@Query("delay") delay: Int) : Call<Page>
}