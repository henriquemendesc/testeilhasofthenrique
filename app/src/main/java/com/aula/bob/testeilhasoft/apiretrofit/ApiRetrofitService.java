package com.aula.bob.testeilhasoft.apiretrofit;

import retrofit2.http.GET;

/**
 * Created by Bob on 17/07/2017.
 */

public interface ApiRetrofitService {
    @GET("/api/partners.json")
    Call<List<Partner>> getPartners();

}
