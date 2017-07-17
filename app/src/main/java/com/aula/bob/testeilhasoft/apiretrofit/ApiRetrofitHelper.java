package com.aula.bob.testeilhasoft.apiretrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bob on 17/07/2017.
 */

public class ApiRetrofitHelper {
    static String api_key = "ec6483bd";
    static String url_base = "http://www.omdbapi.com/?apikey="+api_key+"&";

    public static ApiRetrofitService apiService;

    private static Gson gson = new GsonBuilder()
            .create();

    public static ApiRetrofitService getApiService() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(url_base)
                    .addConverterFactory(GsonConverterFactory.create(gson)).build();
            apiService = retrofit.create(ApiRetrofitService.class);
        }
        return apiService;
    }
}
