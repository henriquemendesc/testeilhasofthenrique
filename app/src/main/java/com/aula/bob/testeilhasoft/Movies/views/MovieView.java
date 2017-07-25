package com.aula.bob.testeilhasoft.Movies.views;

import android.app.Activity;
import android.content.Context;

import com.aula.bob.testeilhasoft.Movies.models.MovieModel;

/**
 * Created by Bob on 21/07/2017.
 */

public interface MovieView {
    Activity getActivity();
    Context getContext();

    void openSearch(MovieModel item);
    void onLoading(boolean loading);
}
