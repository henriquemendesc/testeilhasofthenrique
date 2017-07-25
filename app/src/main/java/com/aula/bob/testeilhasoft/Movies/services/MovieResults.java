package com.aula.bob.testeilhasoft.Movies.services;

import com.aula.bob.testeilhasoft.Movies.models.MovieModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bob on 24/07/2017.
 */

public class MovieResults {

    @SerializedName("Search")
    public List<MovieModel> movies;

    public MovieResults(){}

    public MovieResults(List<MovieModel> movies) {
        this.movies = movies;
    }
}
