package com.aula.bob.testeilhasoft.Movies.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aula.bob.testeilhasoft.Movies.services.MovieResults;
import com.aula.bob.testeilhasoft.Movies.services.MovieService;
import com.aula.bob.testeilhasoft.Movies.views.MovieView;
import com.aula.bob.testeilhasoft.apiretrofit.ApiRetrofitService;

import java.util.List;

/**
 * Created by Bob on 24/07/2017.
 */

public class MoviePresenter {
    MovieView view;
    MovieAdapter adapter;
    MovieService service;

    public MoviePresenter(final Context context, final MovieView view) {
        this.view = view;
        adapter = new MovieAdapter(this);
        service = new MovieService();
       // view.getSearchText().setOnEditorActionListener(onClickDoneKeyboard());
    }

    public void search(String movie){
        view.onProgress();
        String nomeFilme = view.getSearchText().getText().toString();
        service.moviesSearchResult(view.getContext(),nomeFilme, new ApiRetrofitService.MoviesFutureCallback<MovieResults>() {
            @Override
            public void onSuccess(MovieResults movie) {
                adapter.setResults(movie.movies);
                view.getRecyclerView().setAdapter(adapter);
                view.getRecyclerView().setLayoutManager(new LinearLayoutManager(view.getContext()));
                view.getRecyclerView().setHasFixedSize(true);
                view.closeProgess();
/*                if (movie.eq == 0) {
                    Toast.makeText(view.getContext(), "Nenhum resultado encontrado", Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }

    public View.OnClickListener onCardClick(final MovieResults item) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View itemView) {
                //view.openDetails(item);
            }
        };
    }
}
