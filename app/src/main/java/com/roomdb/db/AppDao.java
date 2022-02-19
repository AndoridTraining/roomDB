package com.roomdb.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AppDao {
    @Query("SELECT * FROM AppEntity")
    List<AppEntity> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(AppEntity... users);

    @Delete
    void delete(AppEntity user);
}
