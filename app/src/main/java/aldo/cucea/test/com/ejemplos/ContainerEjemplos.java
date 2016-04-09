package aldo.cucea.test.com.ejemplos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import aldo.cucea.test.com.ejemplos.fragments.CustomList;
import aldo.cucea.test.com.ejemplos.fragments.CustomList2;
import aldo.cucea.test.com.ejemplos.fragments.MovieFragment;

/**
 * Created by Titanium on 12/03/16.
 */
public class ContainerEjemplos extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        int pos = getIntent().getExtras().getInt("numeroEjemplo");
        if (pos == 0 ) {    // Custom List Selected
            getSupportFragmentManager().beginTransaction().replace(R.id.containerFragmentEjemplos, new CustomList()).commit();
        } else if (pos == 1 ) {    // Custom List View Holder Selected
            getSupportFragmentManager().beginTransaction().replace(R.id.containerFragmentEjemplos, new CustomList2()).commit();
        } else if (pos == 2 ) {    // Movies fragment
            getSupportFragmentManager().beginTransaction().replace(R.id.containerFragmentEjemplos, new MovieFragment()).commit();
        }
        //savedInstanceState.getInt("numeroEjemplo");
        Log.wtf("ContainerEjemplos", "Posición: " + pos);
    }
}
