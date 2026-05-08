package com.example.geovault;

import android.os.Bundle;
import android.view.View;


import com.example.geovault.Base.BaseActivity;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends BaseActivity {

    MaterialButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectFinish(AddActivity.class);
            }
        });

    }
}