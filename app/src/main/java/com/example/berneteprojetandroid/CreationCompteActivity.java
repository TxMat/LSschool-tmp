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

    private EditText etName;
    private EditText etPrenom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);

        BDD = BD.getInstance(getApplicationContext());

        Button sumbit = findViewById(R.id.AddUserButton);

        etName = findViewById(R.id.editTextTextPersonName);
        etPrenom = findViewById(R.id.editTextTextPersonPrenom);

        sumbit.setOnClickListener(v -> saveUser());

    }

    private void saveUser() {

        // Récupérer les informations contenues dans les vues
        final String sName = etName.getText().toString().trim();
        final String sPrenom = etPrenom.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
        if (sName.isEmpty()) {
            etName.setError("Entez un nom");
            etName.requestFocus();
            return;
        }

        class SaveUser extends AsyncTask<Void, Void, Comptes> {

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

                // Quand la tache est créée, on arrête l'activité AddTaskActivity (on l'enleve de la pile d'activités)
                setResult(RESULT_OK);
                finish();
                Toast.makeText(getApplicationContext(), "Sauvgradé avec succes !", Toast.LENGTH_LONG).show();
            }
        }

        SaveUser su = new SaveUser();
        su.execute();
    }



}