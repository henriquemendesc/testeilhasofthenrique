package com.aula.bob.testeilhasoft.Movies.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.aula.bob.testeilhasoft.Movies.services.MovieResults;
import com.aula.bob.testeilhasoft.Movies.views.MovieFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob on 24/07/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<MovieResults> results;
    MoviePresenter presenter;

    public MovieAdapter(MoviePresenter presenter) {
        this.results = new ArrayList<>();
        this.presenter = presenter;
    }

    public void setResults(List<MovieResults> results) {
        this.results = results;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
