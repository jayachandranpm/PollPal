package com.votingsystem.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.votingsystem.model.Contestant;
import com.votingsystem.model.User;

@Database(entities = {Contestant.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract ContestantDao contestantDao();
    public abstract UserDao userDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "voting_system_db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}