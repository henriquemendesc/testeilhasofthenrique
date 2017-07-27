package com.aula.bob.testeilhasoft.Movies.presenter;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.aula.bob.testeilhasoft.Movies.persistence.AppDataBase;
import com.aula.bob.testeilhasoft.Movies.persistence.Movies;
import com.aula.bob.testeilhasoft.Movies.views.DetailsView;

/**
 * Created by Bob on 26/07/2017.
 */

public class DetailsPresenter {
    DetailsView view;
    AppDataBase db;

    public DetailsPresenter(final Context context, final DetailsView view) {
        this.view = view;
    }

    public View.OnClickListener onSaveClick(final String plot, final String diretor, String autor,
                                            final String nome, final String tipo, final String ano, final String ator) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View itemView) {
                Movies movies = new Movies(id, titlemovie, plotmovie, idimdbmovie, imagemovie, actormovie, yearmovie, typemovie, directormovie, writermovie);
                movies.setActormovie(ator);
                movies.setDirectormovie(diretor);
                movies.setPlotmovie(plot);
                movies.setTitlemovie(nome);
                movies.setTypemovie(tipo);
                movies.setYearmovie(ano);
//                db.getMovieDao().insertAll(movies);
                Toast.makeText(view.getContext(),"Inserido com Sucesso",Toast.LENGTH_SHORT).show();
            }
        };
    }
}
