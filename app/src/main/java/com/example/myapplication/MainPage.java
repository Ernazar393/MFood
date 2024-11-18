package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class MainPage extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        showAllergyDialog();

        ImageView images = findViewById(R.id.imageView4);
        TextView ingredients = findViewById(R.id.textView4);
        TextView whereICanBuy = findViewById(R.id.textView5);
        TextView ankets = findViewById(R.id.textView6);
        TextView namesFood = findViewById(R.id.textView9);
        Button randomFood = findViewById(R.id.button3);

        ingredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), IngredientsActivity.class);
                startActivity(intent);
            }
        });
        whereICanBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), IngredientsActivity.class);
                startActivity(intent);
            }
        });
        ankets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), IngredientsActivity.class);
                startActivity(intent);
            }
        });
        randomFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] namesOfFood = {"Lagman", "Ramen", "Sup", "Plov",
                        "Jasmyk", "Chuchuk", "Besh barmak", "Chymchyma", "Apamdyn Kattamasy",
                        "Samsy", "Koldun Kurgak Kesmesi", "USA zavtrak", "AshlyanFu", "Zharkop",
                        "Shashlyk", "Chuchbara", "Gulchatai", "Pelmeni"};
                String[] imagesOfFood = {"https://f-o-o-d.ru/upload/iblock/c25/9043lm6p6ky2xqwvvqwkqdu5a1hol8qo/lagman.jpg",
                        "https://images.themodernproper.com/billowy-turkey/production/posts/SlowCookerCurryBeefRamen_11.jpg?w=1200&q=82&auto=format&fit=crop&dm=1676687723&s=8b51b8436205cc5428c9a7300c0ad861",
                        "https://mmbonappetit.com/wp-content/uploads/2021/06/Sup-nui-suon-featured.jpg",
                        "https://ist.say7.info/img0001/18/118_0134bxr_2961_1024.jpg",
                        "https://cdn.yemek.com/mncrop/940/625/uploads/2014/06/mercimek-corbasi-yemekcom.jpg",
                        "https://sputnik.kg/img/102139/24/1021392489_25:0:1170:720_1920x0_80_0_0_44f758061447e28a808fe6c332c5c532.jpg",
                        "https://mf.b37mrtl.ru/rbthmedia/images/2022.10/article/63455abf57050e1389043a1d.jpg",
                        "https://i.ytimg.com/vi/o5i1sf1tJj8/maxresdefault.jpg",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRq2_Jdcwv34NCPpVO9W7FjuQ6GepneinYUWdCZ-08op8dJigrhVKYws4wSwAHm_kJjyl4&usqp=CAU",
                        "https://images.gastronom.ru/pPZD9HypkdcJ3Jhayp0--TVhDx6HvaFdbe1mgr8afYM/pr:recipe-cover-image/g:ce/rs:auto:0:0:0/L2Ntcy9hbGwtaW1hZ2VzLzhmNmY1ODI1LThkYzctNDczYS04NWJiLTUyNDQyMjU1YWMyZC5qcGc.webp",
                        "https://i.ytimg.com/vi/s4qKuHkb3Qg/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLCnAkns99mGeg88RSvMBF9-oHbcDg",
                        "https://bit.ua/wp-content/uploads/2014/08/u.jpg",
                        "https://en.kabar.kg/site/assets/files/39831/whatsapp_image_2023-08-22_at_15_25_04.730x0.jpeg",
                        "https://i.ytimg.com/vi/X7JbkwdexP0/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLAINGQuQ9FNezsOe1h-Cdv4eOB4XQ",
                        "https://img.povar.ru/mobile/26/f7/e2/74/kavkazskii_shashlik-306882.jpg",
                        "https://images.gastronom.ru/RLEm6RZuU56XayHXB7v0WXlnd3aH15oHr-D8nAnL4zA/pr:recipe-cover-image/g:ce/rs:auto:0:0:0/L2Ntcy9hbGwtaW1hZ2VzL2FkYmQzNGIxLTk3ODgtNDEyNS05OGYyLWI0NWI4NDk2YjhlYy5qcGc.webp",
                        "https://fort.crimea.com/catering/uploads/fotos/cacc52cc-7912-11ec-bb93-00155d00fb0d_1.jpg",
                        "https://cdn.momsdish.com/wp-content/uploads/2012/10/Pelmeni-02-scaled.jpg"};

                int num = (int) (Math.random() * namesOfFood.length);
                namesFood.setText(namesOfFood[num]);

                Picasso.get()
                        .load(imagesOfFood[num])
                        .into(images);

            }
        });

    }

    private void showAllergyDialog() {
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

                // Handle the input (e.g., print it or save it)
                // For this example, just show the input in a Toast
//                Toast.makeText(MainPage.this, "I hate you Nurs!", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss(); // Close the dialog
            });

            // Show the dialog
            alertDialog.show();
        }
}