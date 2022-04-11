package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultatAdditionsActivity extends AppCompatActivity {

    public static final String NBJUSTE_KEY = "nbJuste_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_additions);

        int nbJustes = Integer.parseInt(getIntent().getStringExtra(NBJUSTE_KEY));

        if (nbJustes != 10) {
            TextView titre = findViewById(R.id.texteResultat);
            titre.setText("Dommage !");
            TextView phrase = findViewById(R.id.texteNbJustes);
            phrase.setText("Vous avez eu " + (10-nbJustes) + " réponses fausses.");
        }
    }

    public void additionChanger(View view) {
        Intent intent = new Intent(this, MathematiquesActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}