package aldo.cucea.test.com.ejemplos.listeners;

import java.util.List;

import aldo.cucea.test.com.ejemplos.models.Movie;

/**
 * Created by Titanium on 09/04/16.
 */
public interface DownloadListener {
    void  OnSuccessfullyParse(List<Movie> movies);
}
