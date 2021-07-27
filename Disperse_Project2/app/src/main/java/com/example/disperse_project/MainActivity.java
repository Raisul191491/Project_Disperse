package com.example.disperse_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private static int Splash_Time = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent Register_page = new Intent(MainActivity.this, Register.class);
                startActivity(Register_page);
            }
        },Splash_Time);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}