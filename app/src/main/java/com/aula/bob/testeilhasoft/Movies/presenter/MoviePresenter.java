package com.aula.bob.testeilhasoft.Movies.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.aula.bob.testeilhasoft.Movies.models.MovieModel;
import com.aula.bob.testeilhasoft.Movies.views.MovieView;

/**
 * Created by Bob on 24/07/2017.
 */

public class MoviePresenter implements MovieView{
    MovieView view;

    public MoviePresenter(final Context context, final MovieView view) {
        this.view = view;
    }

    public View.OnClickListener onCardClick(final MovieModel item) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View itemView) {
                view.openSearch(item);
            }
        };
    }

    @Override
    public Activity getActivity() {
        return null;
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void openSearch(MovieModel item) {

    }

    @Override
    public void onLoading(boolean loading) {

    }
}
