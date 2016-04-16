package aldo.cucea.test.com.ejemplos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import aldo.cucea.test.com.ejemplos.listeners.OnTabletListener;

/**
 * Created by Titanium on 12/03/16.
 */
public class List extends AppCompatActivity {

    private OnTabletListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        if(findViewById(R.id.contenedorTabletEjemplos) != null){
            listener = (OnTabletListener) getSupportFragmentManager().findFragmentById(R.id.fragmentList);
            listener.modalidadTabletEncontrada(findViewById(R.id.contenedorTabletEjemplos));
        }

    }
}
