package com.example.animalapps.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.animalapps.model.Cat;

import java.util.List;

public class CatRoomDBRepository {


    private CatDAO catDAO;
    LiveData<List<Cat>> mAllCats;

    public CatRoomDBRepository(Application application){
        CatRoomDatabase db = CatRoomDatabase.getDatabase(application);
        catDAO = db.catDao();
        mAllCats = catDAO.getCats();
    }

    public LiveData<List<Cat>> getAllCats() {
        return mAllCats;
    }
    public void insertPosts (List<Cat> resultCat) {
        new insertAsyncTask(catDAO).execute(resultCat);
    }

    private static class insertAsyncTask extends AsyncTask<List<Cat>, Void, Void> {

        private CatDAO mAsyncTaskDao;

        insertAsyncTask(CatDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<Cat>... params) {
            mAsyncTaskDao.insertPosts(params[0]);
            return null;
        }
    }
}
