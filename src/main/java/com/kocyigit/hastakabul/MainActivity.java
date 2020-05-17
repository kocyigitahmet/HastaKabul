package com.kocyigit.hastakabul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    Button btnLogin;
    EditText user;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        user = (EditText)findViewById(R.id.inputUserName);
        pass = (EditText)findViewById(R.id.inputPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd = pass.getText().toString().trim();
                String usr = user.getText().toString().trim();
                if(pwd.equals("123456") && usr.equals("admin")){
                    Intent toPatientActivity = new Intent(getApplicationContext(),PatientActivity.class);
                    startActivity(toPatientActivity);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Hatalı Giriş!",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
