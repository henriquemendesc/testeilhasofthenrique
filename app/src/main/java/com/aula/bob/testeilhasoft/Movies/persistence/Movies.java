package com.aula.bob.testeilhasoft.Movies.persistence;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.widget.ImageView;

/**
 * Created by Bob on 26/07/2017.
 */
@Entity(tableName = "movies")
public class Movies {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idmovie")
    private long id;

    @ColumnInfo(name = "titlemovie")
    private String titlemovie;

    @ColumnInfo(name = "plotmovie")
    private String plotmovie;

    @ColumnInfo(name = "idimdbmovie")
    private String imdbmovie;

    @ColumnInfo(name = "imagemovie")
    private String imagemovie;

    @ColumnInfo(name = "actormovie")
    private String actormovie;

    @ColumnInfo(name = "yearmovie")
    private String yearmovie;

    @ColumnInfo(name = "typemovie")
    private String typemovie;

    @ColumnInfo(name = "directormovie")
    private String directormovie;

    @ColumnInfo(name = "writermovie")
    private String writermovie;


    public Movies(String titlemovie, String plotmovie,
                  String imdbmovie, String imagemovie, String actormovie, String yearmovie, String typemovie,
                  String directormovie, String writermovie) {

        this.titlemovie = titlemovie;
        this.plotmovie = plotmovie;
        this.imdbmovie = imdbmovie;
        this.imagemovie = imagemovie;
        this.actormovie = actormovie;
        this.yearmovie = yearmovie;
        this.typemovie = typemovie;
        this.directormovie = directormovie;
        this.writermovie = writermovie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitlemovie() {
        return titlemovie;
    }

    public void setTitlemovie(String titlemovie) {
        this.titlemovie = titlemovie;
    }

    public String getPlotmovie() {
        return plotmovie;
    }

    public void setPlotmovie(String plotmovie) {
        this.plotmovie = plotmovie;
    }

    public String getActormovie() {
        return actormovie;
    }

    public void setActormovie(String actormovie) {
        this.actormovie = actormovie;
    }

    public String getYearmovie() {
        return yearmovie;
    }

    public void setYearmovie(String yearmovie) {
        this.yearmovie = yearmovie;
    }

    public String getTypemovie() {
        return typemovie;
    }

    public void setTypemovie(String typemovie) {
        this.typemovie = typemovie;
    }

    public String getDirectormovie() {
        return directormovie;
    }

    public void setDirectormovie(String directormovie) {
        this.directormovie = directormovie;
    }

    public String getWritermovie() {
        return writermovie;
    }

    public void setWritermovie(String writermovie) {
        this.writermovie = writermovie;
    }

    public String getImdbmovie(){
        return imdbmovie;
    }

    public void setImdbmovie(String imdbmovie){
        this.imdbmovie = imdbmovie;
    }

    public String getImagemovie(){
        return imagemovie;
    }

    public void setImagemovie(String imagemovie){
        this.imagemovie = imagemovie;
    }
}
