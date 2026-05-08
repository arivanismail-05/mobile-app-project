package com.example.geovault;

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

public class MapActivity extends BaseActivity {
    MaterialToolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.mapview);

        Glide.with(this).load("https://lh3.googleusercontent.com/VKEIvvokZHFk7Sw1pNk9VChgkXzN_Jz8oYr5JHIK4qeHZtCDwDUuy_qh6O4S3Qb2oyGe6kBSvmOw5xlDguenjeENosM8TTfDUsZvIeY=w609").into(imageView);

    }
}