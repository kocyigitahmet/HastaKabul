package com.kocyigit.hastakabul;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class UserRegiser extends Activity {
    Button btnRegister;
    EditText firstName, lastName, patientID;
    Spinner dept;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_register);

        firstName=(EditText)findViewById(R.id.inputFirstName);
        lastName=(EditText)findViewById(R.id.inputLastName);
        patientID=(EditText)findViewById(R.id.inputPatientID);
        dept=(Spinner)findViewById(R.id.inputDept);

        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName = firstName.getText().toString().trim();
                String lName = lastName.getText().toString().trim();
                String pID = patientID.getText().toString().trim();
                String pDept = dept.getSelectedItem().toString().trim();

                if(fName.isEmpty() || lName.isEmpty() || pID.isEmpty() || pDept.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Bilgileri Doldurunuz.",Toast.LENGTH_LONG).show();
                    return;
                }

                    Model model = new Model(fName, lName, pID, pDept);
                    dao db = new dao(getApplicationContext());
                    long id = db.addModel(model);
                    if(id>0){
                        Toast.makeText(getApplicationContext(),"Hasta Başarı ile Kayıt Edildi ID: "+id,Toast.LENGTH_LONG).show();
                        firstName.setText("");
                        lastName.setText("");
                        patientID.setText("");
                    }

                    else{
                        Toast.makeText(getApplicationContext(),"Veritabanında Beklenmeynen Hata Oluştu. id: " + id,Toast.LENGTH_LONG).show();
                    }



                }


        });


    }
}
