package com.example.rakshit_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView product_image;
    TextView product_name, product_price, product_description, product_flavours;
    String name, price, description, flavours;
    int image;
    Button product_buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        product_image = findViewById(R.id.product_image);
        product_name = findViewById(R.id.product_name);
        product_description = findViewById(R.id.product_description);
        product_flavours = findViewById(R.id.product_flavours);
        product_price = findViewById(R.id.product_price);
        product_buy = findViewById(R.id.product_buy);

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

        //On Click even on buy now
        product_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, CheckoutActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("price", price);
                startActivity(intent);

            }
        });

    }
}