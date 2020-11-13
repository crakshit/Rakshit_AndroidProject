package com.example.rakshit_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView product_image;
    TextView product_name, product_price, product_description, product_flavours;
    String name, price, description, flavours;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        product_image = findViewById(R.id.product_image);
        product_name = findViewById(R.id.product_name);
        product_description = findViewById(R.id.product_description);
        product_flavours = findViewById(R.id.product_flavours);
        product_price = findViewById(R.id.product_price);

        name = getIntent().getStringExtra("name");
        description = getIntent().getStringExtra("description");
        flavours = getIntent().getStringExtra("flavours");
        price = getIntent().getStringExtra("price");
        image = getIntent().getIntExtra("image", 0);

        product_name.setText(name);
        product_price.setText(price);
        product_flavours.setText(flavours);
        product_description.setText(description);
        product_image.setImageResource(image);

    }
}