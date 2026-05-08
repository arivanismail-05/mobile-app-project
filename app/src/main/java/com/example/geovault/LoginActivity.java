package com.example.geovault;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.geovault.Base.BaseActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends BaseActivity {

    MaterialButton login;
    TextInputEditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userVal = username.getText().toString();
                String passVal = password.getText().toString();

                if(userVal.equals("alarvya05@gmail.com") && passVal.equals("123")) {

                    SharedPreferences mypref = getSharedPreferences("mypref", MODE_PRIVATE);
                    SharedPreferences.Editor edit = mypref.edit();
                    edit.putBoolean("islogin", true);
                    edit.putString("username", userVal);
                    edit.putString("password", passVal);
                    edit.apply();

                    redirectFinish(MainActivity.class);

                } else {
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}