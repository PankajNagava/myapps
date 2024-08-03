package com.example.form;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewForms extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<formModal> courseModalArrayList;
    private DBHandler dbHandler;
    private FormRVAdapter formRVAdapter;
    private RecyclerView formsRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_form);

        // initializing our all variables.
        courseModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewForms.this);

        // getting our course array
        // list from db handler class.
        courseModalArrayList = dbHandler.readForms();

        // on below line passing our array list to our adapter class.
        formRVAdapter = new FormRVAdapter(courseModalArrayList, ViewForms.this);
        formsRV = findViewById(R.id.idRVForms);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewForms.this, RecyclerView.VERTICAL, false);
        formsRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        formsRV.setAdapter(formRVAdapter);
    }
}