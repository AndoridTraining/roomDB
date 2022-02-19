package com.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.roomdb.db.AppDao;
import com.roomdb.db.AppDatabase;
import com.roomdb.db.AppEntity;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private List<AppEntity> users;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name")
                .fallbackToDestructiveMigration()
                .build();

        insertData("Ahmad", "Hussain");
        try {
            getAllData();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void insertData(String a, String b) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name")
                .fallbackToDestructiveMigration()
                .build();
        AppDao userDao = db.appDao();
        AppEntity entity = new AppEntity(a, b);
        AsyncTask.execute(() ->
                userDao.insertAll(entity)
        );
    }

    public List<AppEntity> getAllUsers() throws ExecutionException, InterruptedException {
        return new GetUsersAsyncTask().execute().get();
    }

    private class GetUsersAsyncTask extends AsyncTask<Void, Void,List<AppEntity>>
    {
        @Override
        protected List<AppEntity> doInBackground(Void... url) {
            return db.appDao().getAll();
        }
    }

    private void getAllData() throws ExecutionException, InterruptedException {
        List<AppEntity> users= getAllUsers();
    }

    public void AddData(View view) {
        insertData("rashid", "hossain");
    }
}

