package com.aula.bob.testeilhasoft.Movies.services;

import android.content.Context;
import android.widget.Toast;

import com.aula.bob.testeilhasoft.apiretrofit.ApiRetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bob on 17/07/2017.
 */

public class MovieService {

    ApiRetrofitService serviceapi = ApiRetrofitService.retrofit.create(ApiRetrofitService.class);

    public void moviesSearchResult(final Context context, String nameMovie, final ApiRetrofitService.MoviesFutureCallback<MovieResults> callback){
        Call<MovieResults> call = serviceapi.getFilmesByName(nameMovie);
        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                if (response.code() == 200){
                        MovieResults results = response.body();
                        callback.onSuccess(results);

                }
            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {
                Toast.makeText(context,"Failure",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
