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

    public void onConnexion(View view) { //aller à la vue connexion
        Intent ConnexionActivityIntent = new Intent(this, ConnexionActivity.class);
        startActivity(ConnexionActivityIntent);
    }

    public void onListeExercices(View view) { //aller directement aux exercices
        Intent ListeExercicesActivityIntent = new Intent(this, ListeExercicesActivity.class);
        ListeExercicesActivityIntent.putExtra(ListeExercicesActivity.NOM_KEY, "élève");
        startActivity(ListeExercicesActivityIntent);
    }

}