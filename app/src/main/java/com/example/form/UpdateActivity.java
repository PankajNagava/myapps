package com.example.form;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class UpdateActivity extends  AppCompatActivity {
    private EditText NameEdt, dobedt, salaryedt;
    private Button updateBtn, deleteBtn;
    private DBHandler dbHandler;
    String Name, dob, salary;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);

        // initializing all our variables.
        NameEdt = findViewById(R.id.idEdtName);
        dobedt = findViewById(R.id.idEdtdob);
        salaryedt = findViewById(R.id.idEdtsalary);

        updateBtn = findViewById(R.id.idBtnUpdateCourse);
        deleteBtn = findViewById(R.id.idBtndeleteCourse);

        // on below line we are initializing our dbhandler class.
        dbHandler = new DBHandler(UpdateActivity.this);

        // on below lines we are getting data which
        // we passed in our adapter class.
        Name = getIntent().getStringExtra("name");
        dob = getIntent().getStringExtra("dob");
        salary = getIntent().getStringExtra("salary");
        id = getIntent().getIntExtra("id",0);
        System.out.println(id);
        // setting data to edit text
        // of our update activity.
        NameEdt.setText(Name);
        dobedt.setText(dob);
        salaryedt.setText(salary);
//        eid.setText(id);

        // adding on click listener to our update course button.
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course
                // method and passing all our edit text values.
                dbHandler.updateCourse( NameEdt.getText().toString(), dobedt.getText().toString(), salaryedt.getText().toString(),id);

                // displaying a toast message that our course has been updated.
                Toast.makeText(UpdateActivity.this, "Course Updated..", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateActivity.this, MainActivity.class);

                startActivity(i);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our course.
                dbHandler.deleteCourse(id);
                Toast.makeText(UpdateActivity.this, "Deleted the course", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}
