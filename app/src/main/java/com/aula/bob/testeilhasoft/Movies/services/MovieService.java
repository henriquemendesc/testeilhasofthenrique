package com.aula.bob.testeilhasoft.Movies.services;

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

    public void moviesSearchResult(String nameMovie, final ApiRetrofitService.MoviesFutureCallback<List<MovieResults>> callback){
        Call<List<MovieResults>> call = serviceapi.getFilmesByName(nameMovie);
        call.enqueue(new Callback<List<MovieResults>>() {
            @Override
            public void onResponse(Call<List<MovieResults>> call, Response<List<MovieResults>> response) {
                if (response.code() == 200){
                    try{
                        List<MovieResults> results = response.body();
                        callback.onSuccess(results);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<MovieResults>> call, Throwable t) {

            }
        });
    }
}
