package com.roomdb.db;

import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

@Database(entities = {AppEntity.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppDao appDao();
}