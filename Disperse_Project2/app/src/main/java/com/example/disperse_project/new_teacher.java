package com.example.disperse_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class new_teacher extends AppCompatActivity {

    private EditText mSubject, mClass, mSalary, mDay, mLocation;
    private Button mRequest;
    private String key;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_teacher);

        mSubject = findViewById(R.id.subjects);
        mClass = findViewById(R.id.classes);
        mSalary = findViewById(R.id.salaries);
        mDay = findViewById(R.id.days);
        mLocation = findViewById(R.id.locations);
        mRequest = findViewById(R.id.submit_request_button);

        mRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subjects =  mSubject.getText().toString();
                String classes =  mClass.getText().toString();
                String salaries =  mSalary.getText().toString();
                String days =  mDay.getText().toString();
                String locations =  mLocation.getText().toString();

                HashMap<String, String> userMap = new HashMap<>();

                userMap.put("subject",subjects);
                userMap.put("classes",classes);
                userMap.put("salary",salaries);
                userMap.put("days",days);
                userMap.put("location",locations);

                root.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).push().setValue(userMap);

            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        finish();
    }
}