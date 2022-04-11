package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onConnexion(View view) {

        // Création d'une intention
        Intent ConnexionActivityIntent = new Intent(this, ConnexionActivity.class);

        // Lancement de la demande de changement d'activité
        startActivity(ConnexionActivityIntent);
    }

    public void onListeExercices(View view) {

        // Création d'une intention
        Intent ListeExercicesActivityIntent = new Intent(this, ListeExercicesActivity.class);

        // Lancement de la demande de changement d'activité
        startActivity(ListeExercicesActivityIntent);
    }

}