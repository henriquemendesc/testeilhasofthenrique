package com.aula.bob.testeilhasoft.Movies.services;

import android.content.Context;
import android.graphics.Movie;
import android.os.AsyncTask;
import android.widget.Toast;

import com.aula.bob.testeilhasoft.Movies.models.MovieModel;
import com.aula.bob.testeilhasoft.Movies.persistence.AppDataBase;
import com.aula.bob.testeilhasoft.Movies.persistence.Movies;
import com.aula.bob.testeilhasoft.Movies.presenter.MovieAdapter;
import com.aula.bob.testeilhasoft.Movies.views.MovieView;
import com.aula.bob.testeilhasoft.apiretrofit.ApiRetrofitClient;
import com.aula.bob.testeilhasoft.apiretrofit.ApiRetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bob on 17/07/2017.
 */

public class MovieService {

    ApiRetrofitService serviceapi = ApiRetrofitClient.getRetrofitClient().create(ApiRetrofitService.class);

    //só é retornado um objeto portanto não é necessário que seja um list, pelo parametro t
    public void moviesSearchByIdResult(final Context context, String idIMDB, final ApiRetrofitService.MoviesFutureCallback<MovieModel> callback) {
        Call<MovieModel> call = serviceapi.getFilmesByID(idIMDB);
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                if (response.code() == 200) {
                    try {
                        MovieModel results = response.body();
                        callback.onSuccess(results);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Toast.makeText(context, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void moviesSearchResult(final MovieView view,String nameMovie, final ApiRetrofitService.MoviesFutureCallback<MovieResults> callback) {
        Call<MovieResults> call = serviceapi.getFilmesBySearch(nameMovie);
        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                if (response.code() == 200) {
                    try {
                        if(response.body().movies != null) {
                            MovieResults results = response.body();
                            callback.onSuccess(results);
                        }else{
                            Toast.makeText(view.getContext(),"Não já filmes para esta consulta",Toast.LENGTH_SHORT).show();
                            view.closeProgess();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {
                Toast.makeText(view.getContext(), "Failure", Toast.LENGTH_SHORT).show();
                view.closeProgess();
            }
        });
    }
}
