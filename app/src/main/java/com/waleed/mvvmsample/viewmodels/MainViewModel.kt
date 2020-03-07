package com.waleed.mvvmsample.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.waleed.mvvmsample.listeners.AppCommonDataListener
import com.waleed.mvvmsample.models.Page
import com.waleed.mvvmsample.models.User
import com.waleed.mvvmsample.repositories.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application),
    AppCommonDataListener {

    private var mainRepository: MainRepository = MainRepository.getInstance(application,this)

    private val userMutableLiveData: MutableLiveData<ArrayList<User>> = MutableLiveData()
    val userLiveData: LiveData<ArrayList<User>> = userMutableLiveData

    fun getUsers(loadDatabase: Boolean, loadNetwork: Boolean) {
        mainRepository.getUsers(loadDatabase, loadNetwork)
    }

    override fun onDataReceived(data: Any?) {
        userMutableLiveData.postValue(data as ArrayList<User>)
    }

    override fun onDataNotReceived() {
        userMutableLiveData.postValue(null)
    }
}