package com.example.disperse_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    EditText mEmail, mPassword;
    ImageButton mLoginButton;
    TextView mRegisterButton;
    FirebaseAuth fAuth;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail          = findViewById(R.id.Email);
        mPassword       = findViewById(R.id.Password_reg);
        fAuth  = FirebaseAuth.getInstance();
        mProgressBar    = findViewById(R.id.progressBar);
        mLoginButton    = findViewById(R.id.login_button);
        mRegisterButton = findViewById(R.id.Send_to_Register);
    }
}