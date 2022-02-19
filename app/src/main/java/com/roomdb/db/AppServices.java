package com.roomdb.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class AppServices{

    private AppDatabase db ;

    public AppServices(Context context){
        db = Room.databaseBuilder(context,
                AppDatabase.class, "database-name")
                .fallbackToDestructiveMigration()
                .build();
    }

    public List<AppEntity> getAllUsers() throws ExecutionException, InterruptedException {
        return new GetUsersAsyncTask().execute().get();
    }


    private class GetUsersAsyncTask extends AsyncTask<Void, Void, List<AppEntity>>
    {
        @Override
        protected List<AppEntity> doInBackground(Void... url) {
            return db.appDao().getAll();
        }
    }
}
