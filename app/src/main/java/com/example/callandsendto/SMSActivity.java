package com.example.callandsendto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SMSActivity extends AppCompatActivity {
    EditText etxtNubmer2;
    ImageButton btImgSMS;
    Button btBackSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        etxtNubmer2 = findViewById(R.id.etxtNumber2);
        btImgSMS = findViewById(R.id.btImgSMS);
        btBackSMS = findViewById(R.id.btBackSMS);
        btImgSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo Intent ảo
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO , Uri.parse("smsto: " + etxtNubmer2.getText().toString()));
                //Khởi động Intent
                startActivity(smsIntent);
            }
        });
       btBackSMS.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
    }
}