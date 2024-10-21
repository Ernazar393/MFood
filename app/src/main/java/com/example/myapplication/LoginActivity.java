package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button ayana = findViewById(R.id.button2);
        TextView saykal = findViewById(R.id.textView);
        EditText asel = findViewById(R.id.editTextTextPassword);

        ayana.setOnClickListener(v ->
                saykal.setText("8 okuuchu tapshyrma atkarbady!!! Eskertuu 1"));
    }
}