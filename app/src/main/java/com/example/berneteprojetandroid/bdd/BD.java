package com.example.berneteprojetandroid.bdd;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Comptes.class}, version = 1, exportSchema = false)
public abstract class BD extends RoomDatabase {

    public abstract ComptesDAO cdDao();

    private static BD INSTANCE;

    public static synchronized BD getInstance(Context context) {

        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context,
                    BD.class, "LSDb")
                    .build();
        }
        return INSTANCE;
    }
}