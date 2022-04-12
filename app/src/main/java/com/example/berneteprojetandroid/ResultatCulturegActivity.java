package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultatCulturegActivity extends AppCompatActivity {

    public static final String NBJUSTE_KEY = "nbJuste_key";
    public static final String NOM_KEY = "nom_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat_cultureg);

        int nbJustes = Integer.parseInt(getIntent().getStringExtra(NBJUSTE_KEY));

        if (nbJustes != 10) {
            TextView titre = findViewById(R.id.texteResultat);
            titre.setText("Dommage !");
            TextView phrase = findViewById(R.id.texteNbJustes);
            phrase.setText("Tu as eu " + (10-nbJustes) + " réponses fausses. Révise encore un peu !");
        }
    }

    public void cultureGChanger(View view) {
        Intent intent = new Intent(this, ListeExercicesActivity.class);
        intent.putExtra(ListeExercicesActivity.NOM_KEY, getIntent().getStringExtra(NOM_KEY));
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}