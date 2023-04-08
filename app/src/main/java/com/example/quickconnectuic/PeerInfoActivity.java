package com.example.quickconnectuic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class PeerInfoActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peer_info);
        sharedPreferences = getSharedPreferences("userProfile", MODE_PRIVATE);
        String inputValue = sharedPreferences.getString("peerInfo", "No Info Available.");
        TextView displayInfo = findViewById(R.id.displayInfo);
        displayInfo.setText(inputValue);
    }
}