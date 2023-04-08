package com.example.quickconnectuic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Quick Connect UIC");

        Button profileButton = findViewById(R.id.myprofileButton);
        profileButton.setOnClickListener(this);

        Button qrButton = findViewById(R.id.qrcodeButton);
        qrButton.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent;

        switch(view.getId()) {
            case R.id.myprofileButton:
                intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.qrcodeButton:
                intent = new Intent(MainActivity.this, QRCodeActivity.class);
                startActivity(intent);
                break;
        }
    }
}