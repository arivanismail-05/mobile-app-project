package com.example.geovault.Base;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.geovault.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupStatusBar();
    }
    private void setupStatusBar() {
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.main_blue));

        getWindow().getDecorView().setSystemUiVisibility(0);
    }

    protected void redirect(Class destination)
    {
        Intent intent = new Intent(this,destination);
        startActivity(intent);
    }
    protected void redirectFinish(Class destination)
    {
        Intent intent = new Intent(this,destination);
        startActivity(intent);
        finish();
    }
}