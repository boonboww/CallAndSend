package com.example.callandsendto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class CallPhoneActivity extends AppCompatActivity {
    EditText etxtNumber;
    ImageButton btImgCallPhone;
    Button btBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);
        etxtNumber = findViewById(R.id.etxtNumber);
        btImgCallPhone = findViewById(R.id.btImgCallPhone);
        btBack = findViewById(R.id.btBackCallPhone);
        btImgCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo Intent ẩn
               try {
                   // Thực hiện Intent gọi điện
                   Intent callPhoneIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + etxtNumber.getText().toString()));

                   // Kiểm tra quyền CALL_PHONE
                   int permissionCheck = ActivityCompat.checkSelfPermission(CallPhoneActivity.this, android.Manifest.permission.CALL_PHONE);

                    // Nếu quyền chưa được cấp, hãy yêu cầu quyền
                   if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                       ActivityCompat.requestPermissions(CallPhoneActivity.this, new String[]{android.Manifest.permission.CALL_PHONE}, 1);
                       return;
                   }

              startActivity(callPhoneIntent);

               }
               catch (Exception e) {
                   Toast.makeText(CallPhoneActivity.this, "Không dùng được", Toast.LENGTH_SHORT).show();

               }
                // Yêu cầu cấp quyền truy cập

            }
        });
        btBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}