package aldo.cucea.test.com.ejemplos.network;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import aldo.cucea.test.com.ejemplos.JSONUtils.JSONParser;
import aldo.cucea.test.com.ejemplos.listeners.DownloadListener;
import aldo.cucea.test.com.ejemplos.models.Movie;

/**
 * Created by Titanium on 09/04/16.
 */
public class NetworkConnection extends AsyncTask<Void,Void,Boolean>{


    private static final String TAG = NetworkConnection.class.getSimpleName();
    private String JSONStr;

    private DownloadListener listener;

    public NetworkConnection(DownloadListener l){
        this.listener = l;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {
            String urlBase = "http://api.themoviedb.org/3/movie/popular";
            Uri builder = Uri.parse(urlBase)
                    .buildUpon()
                    .appendQueryParameter("api_key","c697091e20aaeda1f426d61fb74c55d6")
                    .appendQueryParameter("page","1")
                    .build();
            Log.wtf(TAG,"Request: " + builder.toString());
            URL url = new URL(builder.toString());
            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            //Lectura de InputStream
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if(inputStream == null){
                Log.e(TAG, "Error: No Input Stream");
                return false;
            }
            reader = new BufferedReader(new InputStreamReader((inputStream)));

            //Lectura de buffer
            String line;
            while ((line = reader.readLine()) != null){
                buffer.append(line + "\n");
            }

            //Revision de datos del servidor
            if (buffer.length() == 0){
                Log.e(TAG, "Error: Buffer Empty");
                return false;
            }

            JSONStr = buffer.toString();
            Log.wtf(TAG, "Response server: " + JSONStr);

            return true;

        } catch (IOException e){
            Log.e(TAG, "Error: IOException " + e.toString());
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (result){
            List<Movie> movies = JSONParser.getMovies(JSONStr);
            listener.OnSuccessfullyParse(movies);
            Log.wtf(TAG, "Parser Data Successful ");
        }
    }
}
