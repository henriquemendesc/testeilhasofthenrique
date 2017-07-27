package com.aula.bob.testeilhasoft.Movies.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aula.bob.testeilhasoft.Movies.models.MovieModel;
import com.aula.bob.testeilhasoft.Movies.persistence.Movies;
import com.aula.bob.testeilhasoft.Movies.services.MovieResults;
import com.aula.bob.testeilhasoft.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob on 27/07/2017.
 */

public class CadastradosAdatper extends RecyclerView.Adapter<CadastradosAdatper.ViewHolder> {
    List<Movies> moviesList;
    CadastradosPresenter presenter;

    public CadastradosAdatper(CadastradosPresenter presenter) {
        moviesList = new ArrayList<>();
        this.presenter = presenter;
    }

    public void setResults(List<Movies> result) {
        moviesList = result;
    }

    @Override
    public CadastradosAdatper.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cadastrados_card, parent, false); //inflate layout in view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CadastradosAdatper.ViewHolder holder, int position) {
        ((CadastradosAdatper.ViewHolder) holder).setResult(moviesList.get(position));
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
    public Movies getItem(int position) {
        return moviesList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView posterCad;
        public TextView tituloCad;
        public TextView tipoCad;
        public TextView diretorCad;
        public TextView atorCad;
        public ImageView imageCad;
        public TextView anoCad;
        public TextView autorCad;

        public ViewHolder(View itemView) {
            super(itemView);

            tituloCad = (TextView) itemView.findViewById(R.id.txtTitleCad);
            anoCad = (TextView) itemView.findViewById(R.id.txtYearCadPersistence);
            tipoCad = (TextView) itemView.findViewById(R.id.txtTypeCadPersistence);
            posterCad = (TextView) itemView.findViewById(R.id.txtPlotCad);
            autorCad = (TextView) itemView.findViewById(R.id.txtAutorCadPersistence);
            diretorCad = (TextView) itemView.findViewById(R.id.txtDirectorCadPersistence);
            atorCad = (TextView) itemView.findViewById(R.id.txtActorsCadPersistence);

        }

        public void setResult(Movies item) {
            this.tituloCad.setText(item.getTitlemovie());
            this.anoCad.setText(item.getYearmovie());
            this.tipoCad.setText(item.getTypemovie());
            this.atorCad.setText(item.getActormovie());
            this.posterCad.setText(item.getPlotmovie());
            this.diretorCad.setText(item.getDirectormovie());
            this.autorCad.setText(item.getWritermovie());


        }

        @Override
        public void onClick(View v) {

        }
    }
}
