package com.aula.bob.testeilhasoft.Movies.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Bob on 26/07/2017.
 */
@Database(entities = {Movies.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public static final String DB_NAME = "MoviesDB";
    private static AppDataBase INSTANCE;

    public static AppDataBase getDataBase(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"MoviesDB").build();
        }
        return INSTANCE;
    }

    public abstract MovieDao getMovieDao();
}

