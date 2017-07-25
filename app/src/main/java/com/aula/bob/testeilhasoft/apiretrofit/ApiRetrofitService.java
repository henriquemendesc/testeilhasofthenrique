package com.aula.bob.testeilhasoft.apiretrofit;

import com.aula.bob.testeilhasoft.Movies.models.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Bob on 21/07/2017.
 */

public interface ApiRetrofitService {

    @GET("?t={movieName}&apikey=ec6483bd")
    Call<List<MovieModel>> getFilmesByName(@Path("movieName") String movieName, @Path("apiKey") String apiKey);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
