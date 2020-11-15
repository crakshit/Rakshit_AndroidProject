package com.example.rakshit_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.textfield.TextInputLayout;

public class CheckoutActivity extends AppCompatActivity {

    TextInputLayout fullname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        fullname = findViewById(R.id.fullname);
        String name = fullname.getEditText().getText().toString();
        Log.i("fullname", name);

    }
}