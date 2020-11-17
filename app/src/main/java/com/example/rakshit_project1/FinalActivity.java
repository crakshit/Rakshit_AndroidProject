package com.example.rakshit_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    TextView message, message2;
    Button shop_again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        message = findViewById(R.id.message);
        message2 = findViewById(R.id.message2);
        shop_again = findViewById(R.id.shop_again);

        String name = getIntent().getStringExtra("fullname");
        String email = getIntent().getStringExtra("email");
        message.setText("Thank you, " + name);
        message2.setText("You will receieve further information about your order on " + email +".");

        shop_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(FinalActivity.this, MainActivity.class);
                startActivity(main);
            }
        });


    }
}