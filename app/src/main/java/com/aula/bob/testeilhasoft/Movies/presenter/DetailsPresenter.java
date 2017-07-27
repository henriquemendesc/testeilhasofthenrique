package com.aula.bob.testeilhasoft.Movies.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import com.aula.bob.testeilhasoft.Movies.persistence.AppDataBase;
import com.aula.bob.testeilhasoft.Movies.persistence.Movies;
import com.aula.bob.testeilhasoft.Movies.views.DetailsView;
import com.aula.bob.testeilhasoft.R;

/**
 * Created by Bob on 26/07/2017.
 */

public class DetailsPresenter {
    DetailsView view;
    AppDataBase db;

    public DetailsPresenter(final Context context, final DetailsView view) {
        this.view = view;
    }

    public View.OnClickListener onSaveClick(final String plot, final String diretor, final String autor,
                                            final String nome, final String tipo, final String ano, final String ator,
                                            final String imdb, final String image) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View itemView) {
                db = AppDataBase.getDataBase(view.getContext());
                Movies movies = new Movies(nome,plot,imdb,image,ator,ano,tipo,diretor,autor);//ideal é que a imagem seja salva e retorne o caminho local
                new InsertAsyncTask(db).execute(movies);
                Toast.makeText(view.getContext(), R.string.insert_success,Toast.LENGTH_SHORT).show();
                view.getActvity().finish();
            }
        };
    }

    private class InsertAsyncTask extends AsyncTask<Movies,Void,Void>{
        private AppDataBase db;
        public InsertAsyncTask(AppDataBase appDataBase) {
            db = appDataBase;
        }

        @Override
        protected Void doInBackground(Movies... params) {
            db.getMovieDao().insertAll(params[0]);
            return null;
        }
    }
}
