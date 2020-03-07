package com.waleed.mvvmsample.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.waleed.mvvmsample.models.User

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAll(): List<User>

    @Insert
    fun insert(vararg user: User)

    @Insert
    fun insertAll(users: List<User>)

    @Delete
    fun delete(user: User)

    @Query("DELETE from users")
    fun deleteAll()
}