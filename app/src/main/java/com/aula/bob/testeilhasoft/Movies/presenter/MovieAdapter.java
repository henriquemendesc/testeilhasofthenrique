package com.aula.bob.testeilhasoft.Movies.presenter;

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

    private List<MovieModel> results;
    private MoviePresenter presenter;

    public MovieAdapter(MoviePresenter presenter) {
        setResults(results);
        this.presenter = presenter;
    }

    public void setResults(List<MovieModel> result) {
        results = result;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card, parent, false); //inflate layout in view
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        MovieModel filme = results.get(position);

        Picasso.with(holder.poster.getContext()).load(filme.imgMovie).into(holder.poster);
        holder.titulo.setText(filme.titleMovie);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public MovieModel getItem(int position) {
        return results.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView poster;
        public TextView titulo;

        public ViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView) itemView.findViewById(R.id.txtNome);
            poster = (ImageView) itemView.findViewById(R.id.imgMovie);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            MovieModel filme = getItem(position);
            //mItemListener.onFilmeClick(filme);

        }
    }
}

