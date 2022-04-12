package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListeExercicesActivity extends AppCompatActivity {

    public static final String NOM_KEY = "nom_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_exercices);

        String nom = getIntent().getStringExtra(NOM_KEY);

    }

    public void onExosMaths(View view) {
        Intent ExosMathsActivityIntent = new Intent(this, MathematiquesActivity.class);
        startActivity(ExosMathsActivityIntent);
    }

    public void onExoCultureG(View view) {
        Intent ExoCultureGActivityIntent = new Intent(this, CultureGeneraleActivity.class);
        startActivity(ExoCultureGActivityIntent);
    }
}