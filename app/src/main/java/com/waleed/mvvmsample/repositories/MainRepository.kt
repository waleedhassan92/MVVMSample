package com.waleed.mvvmsample.repositories

import android.content.Context
import android.util.Log
import com.waleed.mvvmsample.DatabaseOperations
import com.waleed.mvvmsample.database.DatabaseHandler
import com.waleed.mvvmsample.database.DatabaseOperationsTask
import com.waleed.mvvmsample.listeners.ApiCallbackListener
import com.waleed.mvvmsample.listeners.AppCommonDataListener
import com.waleed.mvvmsample.listeners.DatabaseListener
import com.waleed.mvvmsample.models.Page
import com.waleed.mvvmsample.models.User
import com.waleed.mvvmsample.network.MainApiCaller

class MainRepository private constructor(
    private val context: Context,
    private val listener: AppCommonDataListener
) : ApiCallbackListener, DatabaseListener {

    init {
        MainApiCaller.initialize()
        DatabaseHandler.initialize(context)
    }

    fun getUsers(loadDatabase: Boolean, loadNetwork: Boolean) {
        if (loadDatabase) {
            getDataFromDatabase()
        }
        if (loadNetwork) {
            getDataFromNetwork()
        }
    }

    override fun onSuccess(requestCode: Int?, responseCode: Int?, data: Any?) {
        val page = data as Page
        saveDataToDatabase(page.data)
        listener.onDataReceived(page.data)
    }

    override fun onFailure(requestCode: Int?, message: String?) {
        listener.onDataNotReceived()
    }

    override fun onOperationSuccess(data: Any?) {
        listener.onDataReceived(data)
    }

    override fun onOperationFailed() {
        listener.onDataNotReceived()
    }

    private fun getDataFromNetwork() {
        MainApiCaller.getUsers(this)
    }

    private fun getDataFromDatabase() {
        DatabaseHandler.getUsersData(this)
    }

    private fun saveDataToDatabase(users: ArrayList<User>) {
        DatabaseHandler.saveUsersData(users, this)
    }

    companion object {
        private lateinit var INSTANCE: MainRepository

        fun getInstance(context: Context, listener: AppCommonDataListener): MainRepository {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = MainRepository(context, listener)
            }
            return INSTANCE
        }
    }
}