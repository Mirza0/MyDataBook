package com.myapplicationdev.android.mydatabook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
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
        String url = "http://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
        Glide.with(this)
                .load(url)
                .apply(new RequestOptions().placeholder(R.drawable.ajax_loader).error(R.drawable.error))
                .into(iv);

    }


}