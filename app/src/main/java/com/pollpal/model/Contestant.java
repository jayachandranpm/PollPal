package com.votingsystem.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contestants")
public class Contestant {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int votes;

    public Contestant(String name) {
        this.name = name;
        this.votes = 0;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}