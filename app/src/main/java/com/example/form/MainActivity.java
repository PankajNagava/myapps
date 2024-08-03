package com.example.form;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbHandler
    private EditText name, dob, salary;
    private Button submit,view;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        name = findViewById(R.id.name);
        dob = findViewById(R.id.dob);
        salary = findViewById(R.id.salary);
        submit = findViewById(R.id.submit);
        view = findViewById(R.id.view);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add course button.
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String name1 = name.getText().toString();
                String dob1 = dob.getText().toString();
                String salary1 = salary.getText().toString();

                // validating if the text fields are empty or not.
                if (name1.isEmpty() && dob1.isEmpty() && salary1.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewForm(name1, dob1, salary1);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Form has been submitted.", Toast.LENGTH_SHORT).show();
                name.setText("");
                dob.setText("");
                salary.setText("");
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity.this, ViewForms.class);
                startActivity(i);
            }
        });
    }
}
