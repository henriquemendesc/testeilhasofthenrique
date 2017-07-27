package com.aula.bob.testeilhasoft.Movies.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.aula.bob.testeilhasoft.Movies.persistence.AppDataBase;
import com.aula.bob.testeilhasoft.Movies.persistence.Movies;
import com.aula.bob.testeilhasoft.Movies.services.MovieService;
import com.aula.bob.testeilhasoft.Movies.views.CadView;
import com.aula.bob.testeilhasoft.Movies.views.MovieView;

import java.util.List;

/**
 * Created by Bob on 27/07/2017.
 */

public class CadastradosPresenter {
    CadView view;
    CadastradosAdatper adapter;
    MovieService service;
    AppDataBase db;

    public CadastradosPresenter(final Context context, final CadView view) {
        this.view = view;
        adapter = new CadastradosAdatper(this);
        service = new MovieService();
    }

    public void loadFromDB(){
        db = AppDataBase.getDataBase(view.getContext());
        new AsyncTask<Void, Void, List<Movies>>() {
            @Override
            protected List<Movies> doInBackground(Void... params) {
                return db.getMovieDao().getAll();
            }

            @Override
            protected void onPostExecute(List<Movies> movieslist) {
                if (movieslist.size() > 0) {
                    adapter.setResults(movieslist);
                    view.getRecyclerView().setLayoutManager(new LinearLayoutManager(view.getContext()));
                    view.getRecyclerView().setHasFixedSize(true);
                    view.getRecyclerView().setAdapter(adapter);
                }
                else {
                    Toast.makeText(view.getContext(),"Não há filmes cadastrados",Toast.LENGTH_SHORT).show();
                    view.getActivity().finish();
                }
            }
        }.execute();
    }
}
