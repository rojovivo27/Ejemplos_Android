package aldo.cucea.test.com.ejemplos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Titanium on 05/03/16.
 */
public class Login extends AppCompatActivity {

    private EditText txtUser;
    private EditText txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        txtUser = (EditText) findViewById(R.id.txtUser);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtUser.getText().toString();
                String pass = txtPassword.getText().toString();

                if(user.equalsIgnoreCase("")){
                    txtUser.setError("Este campo es necesario");
                    txtUser.requestFocus();
                }

                if(pass.equalsIgnoreCase("")){
                    txtPassword.setError("Este campo es necesario");
                    txtPassword.requestFocus();
                }

                if(user.equalsIgnoreCase("aldo") && pass.equalsIgnoreCase("aldo")){
                    Toast.makeText(Login.this,"A huevo!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Login.this,"Pelas :(", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
