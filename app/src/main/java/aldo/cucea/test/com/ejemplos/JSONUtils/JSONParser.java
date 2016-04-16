package aldo.cucea.test.com.ejemplos.JSONUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import aldo.cucea.test.com.ejemplos.models.Movie;

/**
 * Created by Titanium on 09/04/16.
 */
public class JSONParser {
    public static List<Movie> getMovies(String JSONStr){
        List<Movie> movies = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(JSONStr);
            JSONArray results = object.getJSONArray("results");
            String basePath = "http://image.tmdb.org/t/p/w500/";
            for (int i = 0; i<results.length(); i++){
                JSONObject obj = results.getJSONObject(i);
                Movie movie = new Movie(
                        obj.getString("original_title"),
                        obj.getString("overview"),
                        basePath + obj.getString("poster_path"),
                        obj.getString("backdrop_path"),
                        obj.getDouble("popularity"),
                        obj.getDouble("vote_average")
                        );
                movies.add(movie);
            }
            return movies;
        } catch (JSONException e) {
            return null;
        }
    }
}
