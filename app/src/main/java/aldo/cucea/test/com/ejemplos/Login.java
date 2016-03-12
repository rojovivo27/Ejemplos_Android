package aldo.cucea.test.com.ejemplos;

import android.content.Intent;
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

    private String user,pass;


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
                user = txtUser.getText().toString();
                pass = txtPassword.getText().toString();

                if(Validation()) {
                    if (user.equalsIgnoreCase("aldo") && pass.equalsIgnoreCase("aldo")) {
                        Toast.makeText(Login.this, getString(R.string.login_success), Toast.LENGTH_LONG).show();
                        Intent goToList = new Intent(Login.this, List.class);
                        startActivity(goToList);
                    } else {
                        Toast.makeText(Login.this, getString(R.string.login_failure), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private boolean Validation(){
        boolean success = true;
        if(user.equalsIgnoreCase("")){
            txtUser.setError(getString(R.string.required_field_error));
            txtUser.requestFocus();
            success = false;
        }

        if(pass.equalsIgnoreCase("")){
            txtPassword.setError(getString(R.string.required_field_error));
            txtPassword.requestFocus();
            success = false;
        }
        return success;
    }
}
