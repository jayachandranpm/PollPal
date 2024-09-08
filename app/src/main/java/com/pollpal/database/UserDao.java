package com.votingsystem.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.votingsystem.model.User;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    User getUserByUsername(String username);

    @Query("UPDATE users SET otp = :otp WHERE id = :id")
    void updateOtp(int id, String otp);
}