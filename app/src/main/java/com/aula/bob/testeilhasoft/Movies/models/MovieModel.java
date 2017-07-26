package com.aula.bob.testeilhasoft.Movies.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bob on 17/07/2017.
 */

public class MovieModel {
    @SerializedName("imdbID")
    @Expose
    public String idMovie;

    @SerializedName("Title")
    @Expose
    public String titleMovie;

    @SerializedName("Year")
    @Expose
    public String yearMovie ;

    @SerializedName("Poster")
    @Expose
    public String imgMovie;

    @SerializedName("Plot")
    @Expose
    public String plotMovie;

    @SerializedName("Writer")
    @Expose
    public String writerMovie;

    @SerializedName("Type")
    @Expose
    public String typeMovie;

    public MovieModel() {
    }

    public MovieModel(String idMovie, String titleMovie, String yearMovie, String imgMovie, String writerMovie, String plotMovie, String typeMovie) {
        this.idMovie = idMovie;
        this.titleMovie = titleMovie;
        this.yearMovie = yearMovie;
        this.imgMovie = imgMovie;
        this.writerMovie = writerMovie;
        this.plotMovie = plotMovie;
        this.typeMovie = typeMovie;
    }

}
