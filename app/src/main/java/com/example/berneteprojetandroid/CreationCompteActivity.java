package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.berneteprojetandroid.bdd.BD;
import com.example.berneteprojetandroid.bdd.Comptes;


public class CreationCompteActivity extends AppCompatActivity {

    private BD BDD;

    private EditText etNom;
    private EditText etPrenom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);

        BDD = BD.getInstance(getApplicationContext());

        Button creer = findViewById(R.id.creer_bouton);

        etNom = findViewById(R.id.nomCompte);
        etPrenom = findViewById(R.id.prenomCompte);

        creer.setOnClickListener(v -> sauvCompte());

    }

    private void sauvCompte() {

        // Récupérer les informations contenues dans les vues
        final String sName = etNom.getText().toString().trim();
        final String sPrenom = etPrenom.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
        if (sPrenom.isEmpty()) {
            etPrenom.setError("Entre ton prénom !");
            etPrenom.requestFocus();
            return;
        }

        class SauvCompte extends AsyncTask<Void, Void, Comptes> {

            @Override
            protected Comptes doInBackground(Void... voids) {

                Comptes cmpt = new Comptes();
                cmpt.setName(sName);
                cmpt.setPrenom(sPrenom);

                long id = BD.getInstance(getApplicationContext()).cdDao().insert(cmpt);

                cmpt.setId(id);

                return cmpt;
            }

            @Override
            protected void onPostExecute(Comptes cp) {
                super.onPostExecute(cp);
                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Ton compte est créé !", Toast.LENGTH_LONG).show();
            }
        }

        SauvCompte su = new SauvCompte();
        su.execute();
    }



}