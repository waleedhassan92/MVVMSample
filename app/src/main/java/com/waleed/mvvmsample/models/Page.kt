package com.waleed.mvvmsample.models

import com.google.gson.annotations.SerializedName

data class Page(
    val page: Int, @SerializedName("per_page") val perPage: Int,
    val total: Int,
    @SerializedName("total_pages") val totalPages: Int,
    val data: ArrayList<User>
)