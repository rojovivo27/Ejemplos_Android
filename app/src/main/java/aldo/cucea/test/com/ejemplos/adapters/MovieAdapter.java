package aldo.cucea.test.com.ejemplos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import aldo.cucea.test.com.ejemplos.R;
import aldo.cucea.test.com.ejemplos.models.Movie;

/**
 * Created by Titanium on 09/04/16.
 */
public class MovieAdapter extends ArrayAdapter<List<Movie>> {

    private List<Movie> lista;
    private Context context;

    public MovieAdapter(Context context, List<Movie> objects) {
        super(context, R.layout.item_poster_list);
        this.context = context;
        lista = objects;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_poster_list, null);

            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.titleMovie.setText(lista.get(position).getTitle());
        Picasso.with(context)
                .load(lista.get(position).getPoster())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.posterMovie);

        return convertView;
    }

    static class ViewHolder {
        final private TextView titleMovie;
        final private ImageView posterMovie;

        public ViewHolder(View v){

            titleMovie = (TextView)v.findViewById(R.id.titleMovie);
            posterMovie = (ImageView) v.findViewById(R.id.posterMovie);

        }
    }
}
