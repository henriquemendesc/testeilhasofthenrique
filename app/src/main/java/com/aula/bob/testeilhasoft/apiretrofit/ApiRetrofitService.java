package com.aula.bob.testeilhasoft.apiretrofit;

import com.aula.bob.testeilhasoft.Movies.models.MovieModel;
import com.aula.bob.testeilhasoft.Movies.services.MovieResults;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Bob on 21/07/2017.
 */

public interface ApiRetrofitService {

    interface MoviesFutureCallback<T> {

        void onSuccess(T movies);
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("?apiKey=ec6483bd")
    Call<MovieResults> getFilmesByName(@Query("t") String movieName);


}
