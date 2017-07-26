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

    @GET("?apiKey=ec6483bd")
    Call<MovieModel> getFilmesByID(@Query("i") String movieName);
    @GET("?apiKey=ec6483bd")
    Call<MovieResults> getFilmesBySearch(@Query("s") String movieName);


}
