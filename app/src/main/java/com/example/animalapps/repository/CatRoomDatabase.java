package com.example.animalapps.repository;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.animalapps.model.Cat;


@Database(entities = {Cat.class}, version = 2,exportSchema = false)
public abstract class CatRoomDatabase extends RoomDatabase {

    public abstract CatDAO catDao();
    private static CatRoomDatabase INSTANCE;

    public static CatRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CatRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                    CatRoomDatabase.class,
                                    "CatDB")
                                    .fallbackToDestructiveMigration()
                                    .allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback =
            new Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

}
