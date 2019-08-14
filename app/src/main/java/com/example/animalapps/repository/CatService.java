package com.example.animalapps.repository;


import com.example.animalapps.model.Cat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CatService {


    @GET("images/get")
    Call<List<Cat>> getAnimals(@Query("format") String format,
                               @Query("results_per_page") String results_per_page,
                               @Query("size") String size,
                               @Query("type") String type);
}
