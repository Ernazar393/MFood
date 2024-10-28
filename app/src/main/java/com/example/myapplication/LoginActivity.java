package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button signUpPage = findViewById(R.id.button);
        Button login = findViewById(R.id.button2);
        EditText loginET = findViewById(R.id.loginLoginValue);
        EditText passwordET = findViewById(R.id.loginPasswordValue);
        TextView forgotPage = findViewById(R.id.textView2);
        ImageView loginWithGoogle = findViewById(R.id.imageView);
        ImageView loginWithInstagram = findViewById(R.id.imageView3);
        ImageView loginWithTelegram = findViewById(R.id.imageView2);
        Intent signup = new Intent(this, SignUpActivity.class);
        Intent main = new Intent(this, MainPage.class);



        signUpPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(signup);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginValue = loginET.getText().toString();
                String passwordValue = passwordET.getText().toString();

                if (loginValue.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Login  бош кала албайт!", Toast.LENGTH_LONG).show();
                } else if (passwordValue.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Password бош кала албайт!", Toast.LENGTH_LONG).show();
                } else {
                    startActivity(main);
                }
            }
        });
    }
}