package com.waleed.mvvmsample.database

import android.content.Context
import androidx.room.Room
import com.waleed.mvvmsample.DatabaseOperations
import com.waleed.mvvmsample.listeners.DatabaseListener
import com.waleed.mvvmsample.models.User

object DatabaseHandler {

    private lateinit var database: AppDatabase

    fun initialize(context: Context) {
        database = Room.databaseBuilder(context, AppDatabase::class.java, "mvvm-sample")
            .build()
    }

    fun saveUsersData(users: ArrayList<User>, listener: DatabaseListener) {
        DatabaseOperationsTask(
            { saveUsers(users) },
            DatabaseOperations.WRITE,
            listener
        ).execute()
    }

    fun getUsersData(listener: DatabaseListener) {
        DatabaseOperationsTask(
            { getUsers() },
            DatabaseOperations.READ,
            listener
        ).execute()
    }

    private fun saveUsers(users: ArrayList<User>) {
        database.userDao().deleteAll()
        database.userDao().insertAll(users)
    }

    private fun getUsers(): ArrayList<User> {
        return ArrayList(database.userDao().getAll())
    }

}