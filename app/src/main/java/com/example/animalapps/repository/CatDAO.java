package com.example.animalapps.repository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.example.animalapps.model.Cat;

import java.util.List;

@Dao
public interface CatDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addcat(Cat cat);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPosts(List<Cat> resultCat);


    @Query("SELECT * FROM Cat ORDER BY catId ASC")
    LiveData<List<Cat>> getCats();

    @Query("DELETE FROM Cat")
    void deleteAll();


}
