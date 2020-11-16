package com.example.rakshit_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    TextView message, message2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        message = findViewById(R.id.message);
        message2 = findViewById(R.id.message2);

        String name = getIntent().getStringExtra("fullname");
        String email = getIntent().getStringExtra("email");
        message.setText("Thank you, " + name);
        message2.setText("You will get further information on " + email +".");


    }
}