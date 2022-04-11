package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListeExercicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_exercices);
    }

    public void onExosMaths(View view) {

        // Création d'une intention
        Intent ExosMathsActivityIntent = new Intent(this, MathematiquesActivity.class);

        // Lancement de la demande de changement d'activité
        startActivity(ExosMathsActivityIntent);
    }

    public void onExoCultureG(View view) {

        // Création d'une intention
        Intent ExoCultureGActivityIntent = new Intent(this, CultureGeneraleActivity.class);

        // Lancement de la demande de changement d'activité
        startActivity(ExoCultureGActivityIntent);
    }
}