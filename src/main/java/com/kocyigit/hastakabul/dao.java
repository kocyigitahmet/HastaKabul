package com.kocyigit.hastakabul;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class dao extends SQLiteOpenHelper {
    private static final String dbName = "patDB ";
    private static final String table = "patientList";
    private static final int dbVersion = 1;




    public dao(Context context) {
        super(context, dbName,null,dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createDB = "CREATE TABLE " + table +"(ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, patientID TEXT, firstName TEXT, lastName TEXT, patientDep TEXT)";
        db.execSQL(createDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table);

    }

    public long addModel(Model model) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("patientID",model.getPatientID());
        cv.put("firstName",model.getFirstName());
        cv.put("lastName",model.getLastName());
        cv.put("patientDep",model.getDepartment());

       long id = db.insert(table,null,cv);
       return id;
    }


    public List<String> getPatientList(){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[] cols = {"patientID","firstName","lastName","patientDep"};
        Cursor cursor = db.query(table,cols,null,null,null,null,null);
        while (cursor.moveToNext()){
            veriler.add(cursor.getInt(0) + " - " + cursor.getString(1) + " - " + cursor.getString(2) + " - " + cursor.getString(3) + " - " + cursor.getString(4));


        }

        return  veriler;
    }


    /*
    public List<Model> getPatientList() {
        List<Model> patientList = new ArrayList<Model>();
        SQLiteDatabase db = this.getReadableDatabase();
        String listSorgu = "Select * from " + table;

        Cursor cursor = db.rawQuery(listSorgu,null);
        int siraID = cursor.getColumnIndex("patientID");
        int siraName = cursor.getColumnIndex("firstName");
        int siraSurname = cursor.getColumnIndex("lastName");
        int siraDept = cursor.getColumnIndex("patientDep");

        try {
            while (cursor.moveToNext()){
                Model _patient =new Model();
                _patient.setPatientID(String.valueOf(cursor.getInt(siraID)));
                _patient.setFirstName(String.valueOf(cursor.getInt(siraName)));
                _patient.setLastName(String.valueOf(cursor.getInt(siraSurname)));
                _patient.setDepartment(String.valueOf(cursor.getInt(siraDept)));
            }

        }
        finally {
            cursor.close();
            db.close();
        }

        return  patientList;
    } */
}
