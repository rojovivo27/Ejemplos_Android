package aldo.cucea.test.com.ejemplos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import aldo.cucea.test.com.ejemplos.R;
import aldo.cucea.test.com.ejemplos.models.Car;

/**
 * Created by Titanium on 09/04/16.
 */
public class CustomListAdapterViewHolder extends ArrayAdapter<Car> {

    private Car[] carros;
    private Context context;

    public CustomListAdapterViewHolder(Context context, Car[] objects) {
        super(context, R.layout.item_custom_list , objects);
        carros = objects;
        this.context = context;
    }

    @Override
    public int getCount() {
        return carros.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imagenCarro = null;
        TextView nombreCarro=null, descripcionCarro = null, rateCarro = null;
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_custom_list, null);

            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imagenCarro.setImageResource(carros[position].getImagen());
        holder.nombreCarro.setText(carros[position].getName());
        holder.descripcionCarro.setText(carros[position].getDescription());
        holder.rateCarro.setText(String.valueOf(carros[position].getRating()));

        return convertView;
    }

    static class ViewHolder {
        final private ImageView imagenCarro;
        final private TextView nombreCarro, descripcionCarro, rateCarro;

        public ViewHolder(View v){
            imagenCarro = (ImageView) v.findViewById(R.id.imagen);
            nombreCarro = (TextView) v.findViewById(R.id.textNombre);
            descripcionCarro = (TextView) v.findViewById(R.id.textDescription);
            rateCarro = (TextView) v.findViewById(R.id.textRating);
        }
    }
}
