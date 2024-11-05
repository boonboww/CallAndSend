package com.example.callandsendto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SuperBrowserActivity extends AppCompatActivity {
ImageButton btBackSuperBrowser , btSearch;
EditText etxtSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_browser);
        btSearch = findViewById(R.id.btSearch);
        btBackSuperBrowser = findViewById(R.id.btBackSuperBrowser);
        etxtSearch = findViewById(R.id.etxtSearch);
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo Intent ẩn gọi ACTION_VIEW
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www."+etxtSearch.getText().toString()));
                startActivity(webIntent);
            }

        });
        btBackSuperBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}