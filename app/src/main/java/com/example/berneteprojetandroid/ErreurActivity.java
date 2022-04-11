package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ErreurActivity extends AppCompatActivity {

    public static final String NBERR_KEY = "nbErr_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreur);

        String err = getIntent().getStringExtra(NBERR_KEY);
        TextView nb = findViewById(R.id.exercice5_nbErr);
        nb.setText(err);
    }
}