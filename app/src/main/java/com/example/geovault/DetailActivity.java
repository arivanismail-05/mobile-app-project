package com.example.geovault;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.geovault.Base.BaseActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class DetailActivity extends BaseActivity {
    MaterialToolbar toolbar;
    ImageView imgStaticMap;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        imgStaticMap  =  findViewById(R.id.imgStaticMap);

        Glide.with(this).load("https://lh3.googleusercontent.com/VKEIvvokZHFk7Sw1pNk9VChgkXzN_Jz8oYr5JHIK4qeHZtCDwDUuy_qh6O4S3Qb2oyGe6kBSvmOw5xlDguenjeENosM8TTfDUsZvIeY=w609").into(imgStaticMap);

    }
}