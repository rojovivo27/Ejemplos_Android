package aldo.cucea.test.com.ejemplos.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import aldo.cucea.test.com.ejemplos.ContainerEjemplos;
import aldo.cucea.test.com.ejemplos.R;
import aldo.cucea.test.com.ejemplos.Splash;
import aldo.cucea.test.com.ejemplos.listeners.OnTabletListener;

/**
 * Created by Titanium on 12/03/16.
 */
public class List extends Fragment implements OnTabletListener {

    private String [] opciones;// = new String []{"Opción 1","Opción 2","Opción 3","Opción 4","Opción 5"};
    private ListView lista;
    private ArrayAdapter<String> adapter;
    private View containerEjemplos = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        opciones = getResources().getStringArray(R.array.opciones);
        lista = (ListView) v.findViewById(R.id.listEjemplos);
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, opciones);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (containerEjemplos == null) {
                    Intent intent = new Intent(getActivity(), ContainerEjemplos.class);
                    intent.putExtra("numeroEjemplo", position);
                    startActivity(intent);
                } else {
                    if (position == 0) {    // Custom List Selected
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedorTabletEjemplos, new CustomList()).commit();
                    } else if (position == 1) {    // Custom List View Holder Selected
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedorTabletEjemplos, new CustomList2()).commit();
                    } else if (position == 2) {    // Movies fragment
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedorTabletEjemplos, new MovieFragment()).commit();
                    } else if (position == 3 ) {    // Movies fragment recycle
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedorTabletEjemplos, new MovieFragmentRecycler()).commit();
                    }
                }
            }
        });
        return v;
    }

    @Override
    public void modalidadTabletEncontrada(View contenedor) {
        containerEjemplos = contenedor;
    }
}
