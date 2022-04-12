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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);

        BDD = BD.getInstance(getApplicationContext());

        Button sumbit = findViewById(R.id.AddUserButton);

        etName = findViewById(R.id.editTextTextPersonName);

        sumbit.setOnClickListener(v -> saveUser());

    }

    private void saveUser() {

        // Récupérer les informations contenues dans les vues
        final String sName = etName.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
        if (sName.isEmpty()) {
            etName.setError("Entez un nom");
            etName.requestFocus();
            return;
        }

        class SaveUser extends AsyncTask<Void, Void, Comptes> {

            @Override
            protected Comptes doInBackground(Void... voids) {

                return new Comptes();
/*
                // creating a usr
                User usr = new User();
                usr.setName(sName);

                UserDao tmp = db.userDao();

                // adding to database
                long id = db.userDao().insert(usr);

                // mettre à jour l'id de la tache
                // Nécessaire si on souhaite avoir accès à l'id plus tard dans l'activité
                usr.setId(id);


                return usr;*/
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