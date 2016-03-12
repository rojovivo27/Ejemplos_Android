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
 * Created by Titanium on 12/03/16.
 */
public class CustomListAdapter extends ArrayAdapter<Car> {

    private Car[] carros;
    private Context context;

    public CustomListAdapter(Context context, Car[] objects) {
        super(context, R.layout.item_custom_list, objects);
        carros = objects;
        this.context = context;
    }

    @Override
    public int getCount() {
        return carros.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.item_custom_list, null);

        ImageView imagenCarro = (ImageView) convertView.findViewById(R.id.imagen);
        imagenCarro.setImageResource(carros[position].getImagen());

        TextView nombreCarro = (TextView) convertView.findViewById(R.id.textNombre);
        nombreCarro.setText(carros[position].getName());

        TextView descripcionCarro = (TextView) convertView.findViewById(R.id.textDescription);
        descripcionCarro.setText(carros[position].getDescription());

        TextView rateCarro = (TextView) convertView.findViewById(R.id.textRating);
        rateCarro.setText(String.valueOf(carros[position].getRating()));

        return convertView;
    }
}
