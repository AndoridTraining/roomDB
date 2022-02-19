package com.roomdb.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AppEntity {
    @PrimaryKey (autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    public AppEntity(@NonNull String firstName, @NonNull String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}