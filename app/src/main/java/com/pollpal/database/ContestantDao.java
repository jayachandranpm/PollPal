package com.votingsystem.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.votingsystem.model.Contestant;

import java.util.List;

@Dao
public interface ContestantDao {
    @Insert
    void insert(Contestant contestant);

    @Query("SELECT * FROM contestants")
    List<Contestant> getAll();

    @Query("UPDATE contestants SET votes = votes + 1 WHERE name = :name")
    void voteByName(String name);
}