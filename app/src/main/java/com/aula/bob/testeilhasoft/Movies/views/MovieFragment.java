package com.aula.bob.testeilhasoft.Movies.views;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aula.bob.testeilhasoft.Movies.models.MovieModel;
import com.aula.bob.testeilhasoft.Movies.presenter.MoviePresenter;
import com.aula.bob.testeilhasoft.R;

import retrofit2.Call;

public class MovieFragment extends Fragment implements MovieView {
    RecyclerView recyclerView;
    MoviePresenter moviePresenter;

    private OnFragmentInteractionListener mListener;

    public MovieFragment() {
        // Required empty public constructor
    }

    public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
/*        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void openSearch(MovieModel item) {

    }

    @Override
    public void onLoading(boolean loading) {
        ProgressDialog progress = new ProgressDialog(getContext());
        if(loading) {
            progress.setMessage("Carregando");
            progress.setCancelable(false);
            progress.show();
        }else{
            progress.dismiss();
        }
    }

    @Override
    public RecyclerView getRecyclerView() {
        return null;
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
