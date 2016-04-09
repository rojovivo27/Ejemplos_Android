package aldo.cucea.test.com.ejemplos.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import aldo.cucea.test.com.ejemplos.R;
import aldo.cucea.test.com.ejemplos.adapters.CustomListAdapterViewHolder;
import aldo.cucea.test.com.ejemplos.models.Car;

/**
 * Created by Titanium on 09/04/16.
 */
public class CustomList2 extends Fragment {

    private ListView lista;
    private Car[] carros = new Car[]{
            new Car(R.drawable.audi, 1, "Audi","Velocidad"),
            new Car(R.drawable.aveo, 2, "Aveo","Economia"),
            new Car(R.drawable.beetle, 3, "Beettle","Vintage"),
            new Car(R.drawable.mercedes, 4, "Mercedez","Elegancia"),
            new Car(R.drawable.range, 5, "Range","Fuerza"),
    };
    private CustomListAdapterViewHolder adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista_personalizada, container, false);
        lista = (ListView) v.findViewById((R.id.listaPersonalizada));
        adapter = new CustomListAdapterViewHolder(getContext(),carros);
        lista.setAdapter(adapter);
        return v;
    }
}
