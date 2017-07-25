package com.aula.bob.testeilhasoft.Movies.views;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.aula.bob.testeilhasoft.Movies.models.MovieModel;
import com.aula.bob.testeilhasoft.Movies.presenter.MovieAdapter;
import com.aula.bob.testeilhasoft.Movies.presenter.MoviePresenter;
import com.aula.bob.testeilhasoft.Movies.views.MovieFragment;
import com.aula.bob.testeilhasoft.R;

public class MainActivity extends AppCompatActivity implements MovieView{

    MovieAdapter movieAdapter;
    MoviePresenter presenter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = getRecyclerView();
    }

    @Override
    public Activity getActivity() {
        return null;
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void openSearch(MovieModel item) {

    }

    @Override
    public void onLoading(boolean loading) {

    }

    @Override
    public RecyclerView getRecyclerView() {
        return  (RecyclerView) findViewById(R.id.recycler_list);
    }
}
