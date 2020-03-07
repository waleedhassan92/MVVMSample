package com.waleed.mvvmsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.waleed.mvvmsample.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        observeUsersList()
        setListeners()
    }

    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
                .get(MainViewModel::class.java)
    }

    private fun observeUsersList() {
        viewModel.userLiveData.observe(this, Observer {
            list_data.text = it.toString()
        })
    }

    private fun setListeners() {
        load_database.setOnClickListener {
            viewModel.getUsers(true, false)
        }
        load_network.setOnClickListener {

            viewModel.getUsers(false, true)
        }
    }
}
