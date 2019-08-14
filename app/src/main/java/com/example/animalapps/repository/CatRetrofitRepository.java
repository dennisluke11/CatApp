package com.example.animalapps.repository;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import com.example.animalapps.model.Cat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class CatRetrofitRepository {

    private List<Cat> catsList=new ArrayList<>();
    private MutableLiveData<List<Cat>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public CatRetrofitRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Cat>> getMutableLiveData() {

        CatService animalDataService = RestClient.getClient().create(CatService.class);

        String format = "json";
        String results_per_page = "100";
        String size = "small";
        String type = "png";


        Call<List<Cat>> call = animalDataService.getAnimals(format, results_per_page, size, type);

        call.enqueue(new Callback<List<Cat>>() {
            @Override
            public void onResponse(Call<List<Cat>> call, Response<List<Cat>> response) {

                if (response.isSuccessful() == true) {
                    catsList = response.body();
                    CatRoomDBRepository catRoomDBRepository = new CatRoomDBRepository(application);
                    catRoomDBRepository.insertPosts(catsList);
                    mutableLiveData.setValue(catsList);

                } else {
                    Toast.makeText(application, "sorry we are unable to process your request now", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<Cat>> call, Throwable t) {

                Toast.makeText(application, "Opps there might be something wrong with your connectivity, please check your connectivity", Toast.LENGTH_LONG).show();

            }
        });

        return mutableLiveData;
    }











}
