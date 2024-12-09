package com.example.myapplication.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.entity.MainPageEntity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends AppCompatActivity {

    private String tempDieta = " ";
    private int random = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");
        List<MainPageEntity> mainPageEntities = new ArrayList<>();


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // Assuming you're looping through the data
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        MainPageEntity value = snapshot.getValue(MainPageEntity.class);
                        mainPageEntities.add(value);
                    }
                }
                showAllergyDialog(mainPageEntities);

                ImageView images = findViewById(R.id.imageView4);
                TextView ingredients = findViewById(R.id.textView4);
                TextView whereICanBuy = findViewById(R.id.textView5);
                TextView ankets = findViewById(R.id.textView6);
                TextView namesFood = findViewById(R.id.textView9);
                TextView videoTutorial = findViewById(R.id.textView7);
                Button randomFood = findViewById(R.id.button3);

                whereICanBuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shareFunction();
                    }
                });

                ankets.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showAllergyDialog(mainPageEntities);
                    }
                });

                videoTutorial.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String urlLink = mainPageEntities.get(random).getVideoTutorial();


                        if (isValid(urlLink)) {
                            Intent i = new Intent(Intent.ACTION_VIEW);
                            i.setData(Uri.parse(urlLink));
                            startActivity(i);
                        } else videoTutorial.setText("Видео сабагы кошулбаптыр (");
                    }
                });

                randomFood.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        for (int i = 0; i < mainPageEntities.size(); i++) {
                            random = (int) (Math.random() * mainPageEntities.size());
                            if (tempDieta.equals(mainPageEntities.get(random).getCategoryOfFood())) {
                                break;
                            }
                        }
                        namesFood.setText(mainPageEntities.get(random).getNameOfFood());
                        ingredients.setText(mainPageEntities.get(random).getIngredientsOfFood());

                        // Use Glide to load the image
                        Glide.with(getApplicationContext())
                                .load(mainPageEntities.get(random).getImageOfFood())  // Cloudinary image URL
                                .into(images);    // ImageView

                    }
                });
            }


            @Override
            public void onCancelled(DatabaseError error) {
                System.err.println("Error reading data: " + error.toException());
            }
        });

    }

    private void showAllergyDialog(List<MainPageEntity> mainPageEntities) {
        // Inflate the custom dialog layout
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.allergy_dialog_page, null);

        EditText whatHaveAllergy = dialogView.findViewById(R.id.editTextText2);
        EditText sick = dialogView.findViewById(R.id.editTextText3);
        CheckBox trueFood = dialogView.findViewById(R.id.checkBox);
        CheckBox sportFood = dialogView.findViewById(R.id.checkBox2);
        Spinner trueIngredients = dialogView.findViewById(R.id.spinner);
        RadioButton vegetarian = dialogView.findViewById(R.id.radioButton);
        RadioButton vegan = dialogView.findViewById(R.id.radioButton3);
        RadioButton allFood = dialogView.findViewById(R.id.radioButton2);
        Button save = dialogView.findViewById(R.id.button4);


        // Build the dialog
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setView(dialogView);
        AlertDialog alertDialog = dialogBuilder.create();

        // Set button click listener (e.g., handle the input)
        save.setOnClickListener(v -> {
            if (trueFood.isChecked()) {
                tempDieta = "Dieta";
            }
            if (sportFood.isChecked()) {
                tempDieta = "Sport Food";
            }
            if (vegetarian.isChecked()) {
                tempDieta = "Vegeterian";
            }
            if (vegan.isChecked()) {
                tempDieta = "Vegan";
            }
            alertDialog.dismiss(); // Close the dialog
        });

        // Show the dialog
        alertDialog.show();
    }

    private void shareFunction() {
        String sharebody = "Тамак";

        // The value which we will sending through data via
        // other applications is defined
        // via the Intent.ACTION_SEND
        Intent intentt = new Intent(Intent.ACTION_SEND);

        // setting type of data shared as text
        intentt.setType("text/plain");
        intentt.putExtra(Intent.EXTRA_SUBJECT, "Состав");

        // Adding the text to share using putExtra
        intentt.putExtra(Intent.EXTRA_TEXT, sharebody);
        startActivity(Intent.createChooser(intentt, "Тамак апам"));
    }

    private boolean isValid(String url) {
        try            // Try creating a valid URL //
        {
            new URL(url).toURI();
            return true;
        } catch (
                Exception e)         // If there is an Exception while creating the URL object return false since it is invalid
        {
            return false;
        }
    }
}