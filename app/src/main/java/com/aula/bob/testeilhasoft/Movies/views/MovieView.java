package com.aula.bob.testeilhasoft.Movies.views;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.aula.bob.testeilhasoft.Movies.models.MovieModel;
import com.aula.bob.testeilhasoft.Movies.services.MovieResults;

/**
 * Created by Bob on 21/07/2017.
 */

public interface MovieView {
    Activity getActivity();
    Context getContext();

    void openSearch(String movieName, MovieResults item);
    void onProgress();
    void closeProgess();
    RecyclerView getRecyclerView();
    EditText getSearchText();
    void openDetails(MovieModel movieModel);
}
