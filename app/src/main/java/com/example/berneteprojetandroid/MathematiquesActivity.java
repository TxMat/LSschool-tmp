package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MathematiquesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematiques);
    }

    public void onTableDeMultiplications(View view) {
        // Création d'une intention
        Intent ChoixTableActivityIntent = new Intent(this, ChoixTableActivity.class);

        // Lancement de la demande de changement d'activité
        startActivity(ChoixTableActivityIntent);
    }

    public void onAdditions(View view) {

        // Création d'une intention
        Intent AdditionsActivityIntent = new Intent(this, AdditionsActivity.class);

        // Lancement de la demande de changement d'activité
        startActivity(AdditionsActivityIntent);
    }
}