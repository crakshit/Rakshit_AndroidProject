package com.example.rakshit_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;

public class CheckoutActivity extends AppCompatActivity {

    TextInputLayout fullname, email, phone, address, city, state, country, pincode;

    Button confirm;

//    private boolean validateName(){
//        String name = fullname.getEditText().getText().toString().trim();
//
//        if(name.isEmpty()){
//            fullname.setError("Enter name");
//            return false;
//        } else {
//            fullname.setError(null);
//            return true;
//        }
//    }
    AwesomeValidation validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        validator = new AwesomeValidation(ValidationStyle.BASIC);

        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        city = findViewById(R.id.city);
        state = findViewById(R.id.state);
        country = findViewById(R.id.country);
        pincode = findViewById(R.id.pincode);


        confirm = findViewById(R.id.confirm);

        validator.addValidation( this, R.id.fullname, RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        validator.addValidation( this, R.id.email, "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", R.string.invalid_email);
        validator.addValidation( this, R.id.phone, "^\\d{10}$", R.string.invalid_phone);

        validator.addValidation( this, R.id.address, "\\w+(\\s\\w+){1,}", R.string.invalid_address);
        validator.addValidation( this, R.id.city, "[A-z]+", R.string.invalid_city);
        validator.addValidation( this, R.id.state, "[A-z]+", R.string.invalid_state);
        validator.addValidation( this, R.id.country, "[A-z]+", R.string.invalid_country);
        validator.addValidation( this, R.id.pincode, "([ABCEGHJKLMNPRSTVXY]\\d)([ABCEGHJKLMNPRSTVWXYZ]\\d){2}", R.string.invalid_pincode);

        validator.addValidation( this, R.id.cardnumber, "^\\d{16}$", R.string.invalid_cardnumber);
        validator.addValidation( this, R.id.expdate, "(\\d)(\\d)\\/(\\d)(\\d)", R.string.invalid_expdate);
        validator.addValidation( this, R.id.cvv, "(\\d)(\\d)(\\d)", R.string.invalid_cvv);
        validator.addValidation( this, R.id.cardholdername, RegexTemplate.NOT_EMPTY, R.string.invalid_name);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nameInput = fullname.getEditText().getText().toString();
                final String emailInput = email.getEditText().getText().toString();
                //Log.i("fullname", name);


                if(validator.validate()){

                    // Dialouge box
                    MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(CheckoutActivity.this);
                    builder.setTitle("Are you sure?");
                    builder.setMessage("Please click confirm to place an order.");

                    builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(CheckoutActivity.this, FinalActivity.class);
                            intent.putExtra("fullname", nameInput);
                            intent.putExtra("email", emailInput);

                            startActivity(intent);

                        }
                    });

                    builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }

            }
        });

    }
}