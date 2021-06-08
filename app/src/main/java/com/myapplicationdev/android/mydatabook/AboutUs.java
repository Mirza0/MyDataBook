package com.myapplicationdev.android.mydatabook;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AboutUs extends AppCompatActivity {

    ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Intent intent = getIntent();
        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


    }


}