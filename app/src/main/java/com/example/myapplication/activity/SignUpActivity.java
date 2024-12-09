package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.entity.AuthEntity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button loginPage = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        EditText editText = findViewById(R.id.editText);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);
        ImageView loginWithGoogle = findViewById(R.id.imageView);
        ImageView loginWithInstagram = findViewById(R.id.imageView3);
        ImageView loginWithTelegram = findViewById(R.id.imageView2);
        Intent newPage = new Intent(this, LoginActivity.class);
        Intent newPage2 = new Intent(this, MainPage.class);

        loginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(newPage);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTexts = editText.getText().toString();
                String editText2s = editText2.getText().toString();
                String editText3s = editText3.getText().toString();

                if (editTexts.equals("")) {
                    Toast.makeText(getApplicationContext(), "login coudn't be empty", Toast.LENGTH_LONG).show();
                } else if (editText2s.equals("") || editText2s.length() < 8) {
                    //ahkdjsfghkadghf
                    Toast.makeText(getApplicationContext(), "password coudn't be empty or size have to be bigger than 8", Toast.LENGTH_LONG).show();
                } else if (!editText3s.equals(editText2s)) {
                    Toast.makeText(getApplicationContext(), "password are not same", Toast.LENGTH_LONG).show();
                } else {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("auth");

                    AuthEntity authEntity = new AuthEntity(editTexts,editText2s);
                    authEntity.setKey(myRef.push().getKey());

                    myRef.child(authEntity.getKey()).setValue(authEntity);

                    Toast.makeText(getApplicationContext(),"Saved", Toast.LENGTH_LONG).show();
                    startActivity(newPage2);
                }
            }
        });
    }
}