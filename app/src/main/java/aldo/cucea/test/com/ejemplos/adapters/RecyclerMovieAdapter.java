package aldo.cucea.test.com.ejemplos.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import aldo.cucea.test.com.ejemplos.R;
import aldo.cucea.test.com.ejemplos.models.Movie;

/**
 * Created by Titanium on 16/04/16.
 */
public class RecyclerMovieAdapter extends RecyclerView.Adapter<RecyclerMovieAdapter.ViewHolder>{


    private List<Movie> lista;
    private Context context;

    public RecyclerMovieAdapter(Context context, List<Movie> lista) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View convertView = inflater.inflate(R.layout.item_poster_list, null);
        ViewHolder holder = new ViewHolder(convertView);
        return  holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.titleMovie.setText(lista.get(position).getTitle());
        Picasso.with(context)
                .load(lista.get(position).getPoster())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.posterMovie);
        holder.posterMovie.setTag(lista.get(position));
        holder.posterMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movie = (Movie) v.getTag();
                Toast.makeText(context, movie.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        final private TextView titleMovie;
        final private ImageView posterMovie;

        public ViewHolder(View v){
            super(v);
            titleMovie = (TextView)v.findViewById(R.id.titleMovie);
            posterMovie = (ImageView) v.findViewById(R.id.posterMovie);

        }
    }
}
