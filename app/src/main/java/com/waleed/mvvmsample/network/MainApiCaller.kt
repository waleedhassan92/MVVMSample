package com.waleed.mvvmsample.network

import com.waleed.mvvmsample.listeners.ApiCallbackListener
import com.waleed.mvvmsample.models.Page
import retrofit2.Call

object MainApiCaller {

    fun initialize() {
        ApiClient.initialize()
    }

    fun getUsers(listener: ApiCallbackListener) {
        val call: Call<Page> = ApiClient.apiClient.getUsers(1)
        call.enqueue(ApiHandler(USER_API_REQUEST_CODE, listener))
    }

    private const val USER_API_REQUEST_CODE = 1
}