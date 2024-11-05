package com.example.callandsendto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btCallPhone , btSMS , btCamera , btSuperBrowser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btCallPhone = findViewById(R.id.btCallPhone);
        btSMS = findViewById(R.id.btSMS);
        btCamera = findViewById(R.id.btCamera);
        btSuperBrowser = findViewById(R.id.btSuperBrowser);
        btCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo Intent sang CallPhoneActivity
                Intent myIntent = new Intent(MainActivity.this,CallPhoneActivity.class);
                startActivity(myIntent);
            }
        });
        btSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo Intent sang SmsActivity
                Intent myIntent = new Intent(MainActivity.this, SMSActivity.class);
                startActivity(myIntent);
            }
        });
        btCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo Intent gọi CameraActivity
                Intent myIntent = new Intent(MainActivity.this, Camera_Activity.class);
                startActivity(myIntent);
            }
        });
        btSuperBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SuperBrowserActivity.class);
                startActivity(myIntent);
            }
        });

    }
}