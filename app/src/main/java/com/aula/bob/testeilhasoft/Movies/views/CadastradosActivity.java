package com.aula.bob.testeilhasoft.Movies.views;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.aula.bob.testeilhasoft.Movies.presenter.CadastradosPresenter;
import com.aula.bob.testeilhasoft.R;

public class CadastradosActivity extends AppCompatActivity implements CadView{

    CadastradosPresenter presenter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrados);
        presenter = new CadastradosPresenter(getApplicationContext(),this);
        recyclerView = getRecyclerView();
        presenter.loadFromDB();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return (RecyclerView)findViewById(R.id.recycler_list_cad);
    }
}
