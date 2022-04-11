package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.berneteprojetandroid.bdd.BD;
import com.example.berneteprojetandroid.bdd.Comptes;

import java.util.ArrayList;
import java.util.List;

public class ConnexionActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On récupère l'instance de la BDD
        BD dbClient = BD.getInstance(getApplicationContext());

        // On récupère le RecyclerView du layout.
        RecyclerView rvEleves = (RecyclerView) findViewById(R.id.listeElevesView);
        ComptesAdapter adapter = new ComptesAdapter(new ArrayList<Comptes>());
        rvEleves.setAdapter(adapter);
        rvEleves.setLayoutManager(new LinearLayoutManager(this));

    }

    // Récupération des élèves depuis la BDD
    private void getEleves() {
        class GetEleves extends AsyncTask<Void, Void, List<Comptes>> {
            @Override
            protected List<Comptes> doInBackground(Void... voids) {
                // On récupère les élèves depuis la BDD
                List<Comptes> listeEleves = BD.getInstance(getApplicationContext()).cdDao().getAll();
                return listeEleves;
            }

            @Override
            protected void onPostExecute(List<Comptes> eleves) {
                // On affiche les élèves dans le RecyclerView
                super.onPostExecute(eleves);
                // adapter . qqch
            }

        }
        GetEleves getEleves = new GetEleves();
        getEleves.execute();
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Mise à jour des élèves
        getEleves();

    }
}