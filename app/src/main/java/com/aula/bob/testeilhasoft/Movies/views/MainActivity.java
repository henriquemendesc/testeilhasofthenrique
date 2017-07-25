package com.aula.bob.testeilhasoft.Movies.views;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.aula.bob.testeilhasoft.Movies.presenter.MovieAdapter;
import com.aula.bob.testeilhasoft.Movies.presenter.MoviePresenter;
import com.aula.bob.testeilhasoft.Movies.services.MovieResults;
import com.aula.bob.testeilhasoft.R;

public class MainActivity extends AppCompatActivity implements MovieView {

    MovieAdapter movieAdapter;
    MoviePresenter presenter;
    RecyclerView recyclerView;
    ProgressDialog progress;
    private EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MoviePresenter(getApplicationContext(), this);
        recyclerView = getRecyclerView();
        edtText = (EditText)findViewById(R.id.edtSearch);
        edtText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        edtText.setOnEditorActionListener(searchEditListener());
    }

    private TextView.OnEditorActionListener searchEditListener() {
        return new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    presenter.search(edtText.getText().toString());
                    return true;
                }
                return false;
            }
        };
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
    public void openSearch(String movieName, MovieResults item) {

    }

    @Override
    public void onProgress() {
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setTitle("Aguarde um momento....");
        progress.setMessage("Pesquisando os filmes");
        progress.show();
    }

    @Override
    public void closeProgess() {
        progress.dismiss();
    }

    @Override
    public RecyclerView getRecyclerView() {
        return (RecyclerView) findViewById(R.id.recycler_list);
    }

    @Override
    public EditText getSearchText() {
        return (EditText) findViewById(R.id.edtSearch);

    }

    @Override
    public void openDetails(MovieResults item) {

    }
}
