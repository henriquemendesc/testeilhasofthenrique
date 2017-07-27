package com.aula.bob.testeilhasoft.Movies.views;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Bob on 27/07/2017.
 */

public interface CadView {
    Activity getActivity();
    Context getContext();
    RecyclerView getRecyclerView();
}
