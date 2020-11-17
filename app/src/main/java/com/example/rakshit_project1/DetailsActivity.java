package com.example.rakshit_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.material.textfield.TextInputLayout;

public class DetailsActivity extends AppCompatActivity {

    AwesomeValidation validator;
    ImageView product_image;
    TextView product_name, product_price, product_description, product_flavours;
    TextInputLayout product_qty;

    String name, price, description, flavours, qty;
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
        product_qty = findViewById(R.id.product_qty);

        validator = new AwesomeValidation(ValidationStyle.BASIC);
        validator.addValidation(this,R.id.product_qty,"^([1-9]){1}[\\d]*",R.string.invalid_qty);

        name = getIntent().getStringExtra("name");
        description = getIntent().getStringExtra("description");
        flavours = getIntent().getStringExtra("flavours");
        price = getIntent().getStringExtra("price");
        image = getIntent().getIntExtra("image", 0);
        Log.i("image", ""+image);

        product_name.setText(name);
        product_price.setText(price);
        product_flavours.setText(flavours);
        product_description.setText(description);
        product_image.setImageResource(image);

        //On Click even on buy now
        product_buy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(validator.validate()){
                    qty =  product_qty.getEditText().getText().toString();
                    Intent intent = new Intent(DetailsActivity.this, CheckoutActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("price", price);
                    intent.putExtra("image", image);
                    intent.putExtra("qty", qty);
                    startActivity(intent);
                }
            }
        });

    }
}