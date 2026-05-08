package com.example.geovault;

import android.os.Bundle;
import android.view.View;

import com.example.geovault.Base.BaseActivity;
import com.google.android.material.button.MaterialButton;

public class LoginActivity extends BaseActivity {

    MaterialButton login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectFinish(MainActivity.class);
            }
        });

    }
}