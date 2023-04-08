package com.example.quickconnectuic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class DisplayCodeActivity extends AppCompatActivity {
    // Variables
    private Bitmap bitmap;
    //private ImageView qrImage;
    private ImageView codeDisplayImage;
    SharedPreferences sharedPreferences;
    int smallerDimension = 1000; // TODO - Change to scale dynamically


    //sharedPreferences.edit().putString("userInfo", profileDescription).commit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaycode);

        codeDisplayImage = findViewById(R.id.codeDisplayImage);
        createQRCode(smallerDimension);
    }

    void createQRCode(int smallerDimension){
        sharedPreferences = getSharedPreferences("userProfile", MODE_PRIVATE);
        String inputValue = sharedPreferences.getString("userInfo", "No Info Available.");
        // Initializing the QR Encoder with your value to be encoded, type you required and Dimension
        QRGEncoder qrgEncoder = new QRGEncoder(inputValue, null, QRGContents.Type.TEXT, smallerDimension);
        qrgEncoder.setColorBlack(Color.BLACK);
        qrgEncoder.setColorWhite(Color.WHITE);
        try {
            // Getting QR-Code as Bitmap
            bitmap = qrgEncoder.getBitmap();
            // Setting Bitmap to ImageView
            //qrImage.setImageBitmap(bitmap);
            codeDisplayImage.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}