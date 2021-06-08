package com.myapplicationdev.android.mydatabook;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends AppCompatActivity {

    ActionBar ab;
    TextView tvAuthors;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        iv = findViewById(R.id.ivRP);
        tvAuthors = findViewById(R.id.tvAuthors);
        tvAuthors.setText("Created by Julien, Ju Long, Mirza and David.");
        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        String url = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
        Picasso.with(this).load(url).into(iv);


    }


}