package com.aula.bob.testeilhasoft.Movies.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Bob on 17/07/2017.
 */

public class MovieModel {
    @SerializedName("imdbID")
    public String idMovie;

    @SerializedName("Title")
    public String titleMovie;

    @SerializedName("Year")
    public String yearMovie ;

    @SerializedName("Poster")
    public String imgMovie;

    public MovieModel() {
    }

    public MovieModel(String idMovie, String titleMovie, String yearMovie, String imgMovie) {
        this.idMovie = idMovie;
        this.titleMovie = titleMovie;
        this.yearMovie = yearMovie;
        this.idMovie = imgMovie;
    }

}
