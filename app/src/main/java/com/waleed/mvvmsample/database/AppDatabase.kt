package com.waleed.mvvmsample.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.waleed.mvvmsample.models.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}