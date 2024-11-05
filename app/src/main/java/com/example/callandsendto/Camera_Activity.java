package com.example.callandsendto;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera_Activity extends AppCompatActivity {
    ImageButton btImgCamera , btBackCamera;
    ImageView myImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btImgCamera = findViewById(R.id.btImgCamera);
        myImg = findViewById(R.id.myImg);
        btBackCamera = findViewById(R.id.btBackCamera);
        btBackCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btImgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo Intent ẩn gọi ACTION_IMAGE_CAPTURE
                Intent cameraIntent = new Intent(ACTION_IMAGE_CAPTURE);
                // Yêu cầu quyền truy cập CAMERA
                int permissionCheck = ActivityCompat.checkSelfPermission(Camera_Activity.this, Manifest.permission.CAMERA);
                if(permissionCheck == PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(Camera_Activity.this, new String[]{Manifest.permission.CAMERA}, 1);
                    return;
                }
                // khởi động Intent và trả về hình ảnh
                startActivityForResult(cameraIntent,99);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode == RESULT_OK){
            Bitmap myPhoto = (Bitmap) data.getExtras().get("data");
            myImg.setImageBitmap(myPhoto);
        }
    }

}