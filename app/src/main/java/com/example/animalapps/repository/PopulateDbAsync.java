package com.example.animalapps.repository;

import android.os.AsyncTask;

public class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final CatDAO mDao;

    PopulateDbAsync(CatRoomDatabase db) {
        mDao = db.catDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        mDao.deleteAll();

        return null;

    }
}
