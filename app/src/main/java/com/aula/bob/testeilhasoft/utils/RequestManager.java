package com.aula.bob.testeilhasoft.utils;

import com.aula.bob.testeilhasoft.Movies.models.MovieModel;
import com.aula.bob.testeilhasoft.apiretrofit.ApiRetrofitService;

import java.util.List;

import javax.security.auth.callback.Callback;

import retrofit2.Call;
import retrofit2.http.Path;

/**
 * Created by Bob on 17/07/2017.
 */

public class RequestManager implements ApiRetrofitService {
    static String api_key = "ec6483bd";
    static String url_base = "http://www.omdbapi.com/";


    @Override
    public Call<List<MovieModel>> getFilmesByName(@Path("movieName") String movieName, @Path("apiKey") String apiKey) {
        return null;
    }
}
