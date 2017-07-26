package com.aula.bob.testeilhasoft.Movies.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aula.bob.testeilhasoft.Movies.models.MovieModel;
import com.aula.bob.testeilhasoft.Movies.services.MovieResults;
import com.aula.bob.testeilhasoft.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob on 24/07/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private MovieResults results;
    private List<MovieModel> movieModel;
    private MoviePresenter presenter;

    public MovieAdapter(MoviePresenter presenter) {
        movieModel = new ArrayList<>();
        this.presenter = presenter;
    }

    public void setResults(MovieResults result) {
        results = result;
        movieModel = result.movies;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card, parent, false); //inflate layout in view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ((ViewHolder) holder).setResult(movieModel.get(position));
        //MovieModel filme = results.get(position);
    }

    @Override
    public int getItemCount() {
        return results.movies.size();
    }

    public MovieModel getItem(int position) {
        return results.movies.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView poster;
        public TextView titulo;
        public TextView tipo;
        public TextView ano;

        public ViewHolder(View itemView) {
            super(itemView);

            titulo = (TextView) itemView.findViewById(R.id.txtNome);
            ano = (TextView) itemView.findViewById(R.id.txtAno);
            tipo = (TextView) itemView.findViewById(R.id.txtType);
            poster = (ImageView) itemView.findViewById(R.id.imgMovie);
            itemView.setOnClickListener(this);

        }

        public void setResult(MovieModel item) {
            this.itemView.setOnClickListener(presenter.onCardClick(item));
            Picasso.with(itemView.getContext()).load(item.imgMovie).into(this.poster);
            this.titulo.setText(item.titleMovie);
            this.ano.setText(item.yearMovie);
            this.tipo.setText(item.typeMovie);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            MovieModel filme = getItem(position);
            //mItemListener.onFilmeClick(filme);

        }
    }
}

