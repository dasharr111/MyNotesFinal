package com.example.mynotes20.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mynotes20.Models.Notes;

@Database(entities = Notes.class, version = 1, exportSchema = false) // создаем дб
public abstract class RoomDB extends RoomDatabase{
    private static RoomDB database;
    private static String DATABASE_NAME = "notes"; //имя дб

    public synchronized static RoomDB getInstance(Context context) {
        if (database == null) { //проверяем есть ли у нас дб
            database = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
    public abstract MainDAO mainDAO();
}
