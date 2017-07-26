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
    @BindView(R.id.txtYearDetailsPersistence)
    TextView txtAno;
    @BindView(R.id.txtTypeDetailsPersistence)
    TextView txtTipo;
    @BindView(R.id.txtActorsDetailsPersistence)
    TextView txtAtor;
    @BindView(R.id.imgMovieDetails)
    ImageView imgFilme;

    MovieModel movieModel;
    String image;
    String plot;
    String autor;
    String nome;
    String diretor;
    String tipo;
    String ano;
    String ator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        initializeDetails();
    }

    private void initializeDetails() {
        Intent intent = getIntent();

        image = intent.getStringExtra("image");
        plot = intent.getStringExtra("plot");
        diretor = intent.getStringExtra("director");
        autor = intent.getStringExtra("autor");
        nome = intent.getStringExtra("name");
        tipo = intent.getStringExtra("type");
        ano = intent.getStringExtra("year");
        ator = intent.getStringExtra("actor");

        txtSobre.setText(plot);
        txtDiretor.setText(diretor);
        txtNome.setText(nome);
        txtAno.setText(ano);
        txtTipo.setText(tipo);
        txtAtor.setText(ator);
        Picasso.with(this).load(image).into(this.imgFilme);
    }
}
