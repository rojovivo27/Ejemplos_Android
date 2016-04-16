package aldo.cucea.test.com.ejemplos.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import java.util.*;
import java.util.List;

import aldo.cucea.test.com.ejemplos.R;
import aldo.cucea.test.com.ejemplos.adapters.MovieAdapter;
import aldo.cucea.test.com.ejemplos.listeners.DownloadListener;
import aldo.cucea.test.com.ejemplos.models.Movie;
import aldo.cucea.test.com.ejemplos.network.NetworkConnection;

/**
 * Created by Titanium on 09/04/16.
 */
public class MovieFragment extends Fragment implements DownloadListener {

    private GridView lista;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies = new ArrayList();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_movie,container,false);
        if(savedInstanceState != null){
            movies = savedInstanceState.getParcelableArrayList("lista");
        } else {
            NetworkConnection connection = new NetworkConnection(this);
            connection.execute();
        }
        lista = (GridView)v.findViewById(R.id.listaMovies);
        return v;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState != null){
            movies = savedInstanceState.getParcelableArrayList("lista");
        }
    }

    @Override
    public void OnSuccessfullyParse(List<Movie> movies) {
        for(Movie movie : movies){
            this.movies.add(movie);
        }
        adapter = new MovieAdapter(getContext(),movies);
        lista.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (movies != null && movies.size() >= 0){
            outState.putParcelableArrayList("lista", movies);
        }
        super.onSaveInstanceState(outState);
    }
}
