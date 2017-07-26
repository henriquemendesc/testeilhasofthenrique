package com.aula.bob.testeilhasoft.Movies.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aula.bob.testeilhasoft.Movies.models.MovieModel;
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

/*    public void searchByTitle(String movie){
        view.onProgress();
        String nomeFilme = view.getSearchText().getText().toString();
        service.moviesSearchByTitleResult(view.getContext(),nomeFilme, new ApiRetrofitService.MoviesFutureCallback<MovieModel>() {
            @Override
            public void onSuccess(MovieResults movie) {
                adapter.setResults(movie.movies);
                view.getRecyclerView().setAdapter(adapter);
                view.getRecyclerView().setLayoutManager(new LinearLayoutManager(view.getContext()));
                view.getRecyclerView().setHasFixedSize(true);
                view.closeProgess();
                hideSoftKeyboard(view.getActivity());
            }
        });
    }*/

    public void search(){
        view.onProgress();
        String nomeFilme = view.getSearchText().getText().toString();
        service.moviesSearchResult(view.getContext(),nomeFilme, new ApiRetrofitService.MoviesFutureCallback<MovieResults>() {
            @Override
            public void onSuccess(MovieResults movie) {
                adapter.setResults(movie);

                view.getRecyclerView().setLayoutManager(new LinearLayoutManager(view.getContext()));
                view.getRecyclerView().setHasFixedSize(true);
                view.getRecyclerView().setAdapter(adapter);
                view.closeProgess();
                hideSoftKeyboard(view.getActivity());
            }
        });
    }

    public View.OnClickListener onCardClick(final MovieModel item) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View itemView) {
                Toast.makeText(view.getContext(),item.idMovie.toString(),Toast.LENGTH_SHORT).show();
            }
        };
    }

    public static void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
