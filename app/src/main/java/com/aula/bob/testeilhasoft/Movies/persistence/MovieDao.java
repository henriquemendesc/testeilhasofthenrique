package com.aula.bob.testeilhasoft.Movies.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Bob on 26/07/2017.
 */

@Dao
public interface MovieDao {

    @Insert
    void insertAll(Movies movies);

    @Update
    void updateAll(Movies... notes);

    @Query("SELECT * FROM moviestb")
    List<Movies> getAll();

    @Delete
    void deleteAll(Movies... notes);

}
