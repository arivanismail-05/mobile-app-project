package com.example.geovault;

import android.os.Bundle;
import android.view.View;

import com.example.geovault.Base.BaseActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class VisitedActivity extends BaseActivity {
    MaterialToolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visited);


        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}