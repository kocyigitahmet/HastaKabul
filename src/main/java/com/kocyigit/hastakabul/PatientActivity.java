package com.kocyigit.hastakabul;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class PatientActivity extends Activity {
    Button btnRegister;
    Button btnRef;
    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_main);

        btnRef = (Button)findViewById(R.id.btnRefresh);
        listview = (ListView) findViewById(R.id.hastaListele);
        btnRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao db = new dao(PatientActivity.this);
                List<String> veriler = db.getPatientList();
                ArrayAdapter<String> adapter  = new ArrayAdapter<String>(PatientActivity.this,R.layout.support_simple_spinner_dropdown_item,veriler);
                listview.setAdapter(adapter);

            }
        });

        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRegister = new Intent(getApplicationContext(),UserRegiser.class);
                startActivity(toRegister);
            }
        });

    }

}
