package com.example.quickconnectuic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    // Global Variable(s)
    EditText textToConvert;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("My Profile");

        Button generateQRButton = findViewById(R.id.generateQRButton);
        generateQRButton.setOnClickListener(this);

        textToConvert = findViewById(R.id.textToConvert);
        //textToConvert.setText(sharedPreferences.getString("userInfo", "No Info Available."));
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.generateQRButton:
                String profileDescription = textToConvert.getText().toString();
                // Store string profileDescription
                sharedPreferences = getSharedPreferences("userProfile", MODE_PRIVATE);
                sharedPreferences.edit().putString("userInfo", profileDescription).commit();
                // Start new activity
                startActivity(new Intent(this, DisplayCodeActivity.class));
                break;
        }
    }
}

