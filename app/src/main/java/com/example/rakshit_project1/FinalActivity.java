package com.example.rakshit_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        message = findViewById(R.id.message);
        String name = getIntent().getStringExtra("fullname");
        message.setText("Thank you, " + name);
    }
}