package com.example.animalapps.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.animalapps.model.Cat;
import com.example.animalapps.repository.CatRetrofitRepository;
import com.example.animalapps.repository.CatRoomDBRepository;

import java.util.List;

public class CatListViewModel extends AndroidViewModel {

    private CatRoomDBRepository catRoomDBRepository;
    private LiveData<List<Cat>> mAllCats;
    CatRetrofitRepository catRetrofitRepository;
    private final LiveData<List<Cat>>  retroObservable;


    public CatListViewModel(@NonNull Application application) {
        super(application);
        catRoomDBRepository = new CatRoomDBRepository(application);
        catRetrofitRepository= new CatRetrofitRepository(application);
        retroObservable = catRetrofitRepository.getMutableLiveData();
        mAllCats= catRoomDBRepository.getAllCats();
    }

    public LiveData<List<Cat>> getAllCats() {
        return  mAllCats;
    }
}
