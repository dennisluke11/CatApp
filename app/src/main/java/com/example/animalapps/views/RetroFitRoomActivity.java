package com.example.animalapps.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.animalapps.R;


public class RetroFitRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrolive_room);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_retro_room,new com.example.animalapps.views.RetroFitPostFragment()).commit();
    }
}
