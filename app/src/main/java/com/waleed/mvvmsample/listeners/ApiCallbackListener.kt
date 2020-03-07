package com.waleed.mvvmsample.listeners

interface ApiCallbackListener {
    fun onSuccess(requestCode: Int?, responseCode: Int?, data: Any?)
    fun onFailure(requestCode: Int?, message: String?)
}