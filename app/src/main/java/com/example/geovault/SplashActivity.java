package com.example.geovault;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;


import com.example.geovault.Base.BaseActivity;
import com.google.android.material.button.MaterialButton;

public class SplashActivity extends BaseActivity {

    MaterialButton btnGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        btnGetStarted = findViewById(R.id.btnGetStarted);


        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectFinish(MainActivity.class);
            }
        });




    }
}