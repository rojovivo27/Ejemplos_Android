package aldo.cucea.test.com.ejemplos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent goToLogin = new Intent(Splash.this, Login.class);
                    startActivity(goToLogin);
                    finish();
                }
            }
        };

        t.start();

    }
}
