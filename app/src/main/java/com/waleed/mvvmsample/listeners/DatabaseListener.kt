package com.waleed.mvvmsample.listeners

interface DatabaseListener {
    fun onOperationSuccess(data: Any?)
    fun onOperationFailed()
}