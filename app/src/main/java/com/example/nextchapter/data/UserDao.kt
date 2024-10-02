package com.example.nextchapter.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    // Insert a new user
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    // Check if a user exist with a given username password
    // (for login)
    @Query(
        "SELECT * FROM user_table WHERE username = :username" +
                " AND password =:password LIMIT 1"
    )
    suspend fun login(username: String, password: String): User?

    //Checks if a username is taken
    //For Sign up
    @Query("SELECT * FROM user_table WHERE username = :username LIMIT 1")
    suspend fun getUserByUserName(username: String): User?

    @Query("SELECT * FROM user_table WHERE salt =''")
    suspend fun  getUserWithoutSalt():List<User>

    @Update
    suspend fun update(user: User)

}