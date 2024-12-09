package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.entity.AuthEntity;
import com.example.myapplication.entity.MainPageEntity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button signUpPage = findViewById(R.id.button);
        Button login = findViewById(R.id.button2);
        EditText loginET = findViewById(R.id.loginLoginValue);
        EditText passwordET = findViewById(R.id.loginPasswordValue);
        TextView forgotPass = findViewById(R.id.textView2);
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
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("auth");

                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                boolean loginChecker = false;
                                // Assuming you're looping through the data
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    AuthEntity value = snapshot.getValue(AuthEntity.class);

                                    if (value.getLogin().equals(loginValue) && value.getPass().equals(passwordValue)) {
                                        startActivity(main);
                                        loginChecker = true;
                                    }
                                }
                                if (!loginChecker)
                                    Toast.makeText(getApplicationContext(), "Туура эмес логин же сыр соз (", Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            System.err.println("Error reading data: " + error.toException());
                        }

                    });
                }
            }
        });
    }
}