package com.aula.bob.testeilhasoft.Movies.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.aula.bob.testeilhasoft.Movies.models.MovieModel;
import com.aula.bob.testeilhasoft.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {
    @BindView(R.id.txtPlotDetails)
    TextView txtSobre;
    @BindView(R.id.txtAutorDetailsPersistence)
    TextView txtAutor;
    @BindView(R.id.txtDirectorDetailsPersistence)
    TextView txtDiretor;
    @BindView(R.id.txtTitleDetails)
    TextView txtNome;
    @BindView(R.id.imgMovieDetails)
    ImageView imgFilme;

    MovieModel movieModel;
    String image;
    String plot;
    String autor;
    String nome;
    String diretor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        image = intent.getStringExtra("image");
        plot = intent.getStringExtra("plot");
        diretor = intent.getStringExtra("director");
        autor = intent.getStringExtra("autor");
        nome = intent.getStringExtra("name");
        initializeDetails();
    }

    private void initializeDetails() {
        txtSobre.setText(plot);
        txtDiretor.setText(diretor);
        txtNome.setText(nome);
        Picasso.with(this).load(image).into(this.imgFilme);
    }
}
