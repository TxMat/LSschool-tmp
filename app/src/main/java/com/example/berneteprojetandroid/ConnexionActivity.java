package com.example.berneteprojetandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;

import com.example.berneteprojetandroid.bdd.BD;
import com.example.berneteprojetandroid.bdd.Comptes;

import java.util.ArrayList;
import java.util.List;

public class ConnexionActivity extends AppCompatActivity {

    private ArrayList<Comptes> cmpt = new ArrayList<>();
    private ComptesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        // On récupère le RecyclerView du layout.
        RecyclerView rvEleves = (RecyclerView) findViewById(R.id.rvComptes);
        adapter = new ComptesAdapter(cmpt, this);
        rvEleves.setAdapter(adapter);
        rvEleves.setLayoutManager(new LinearLayoutManager(this));

        Button creer = findViewById(R.id.bouton_nvcompte);

        creer.setOnClickListener(v -> {
            Intent intent = new Intent(this, CreationCompteActivity.class);
            startActivity(intent);

        });

    }

    // Récupération des élèves depuis la BDD
    private void getEleves() {
        class GetEleves extends AsyncTask<Void, Void, List<Comptes>> {
            @Override
            protected List<Comptes> doInBackground(Void... voids) {
                List<Comptes> lc = BD.getInstance(getApplicationContext()).cdDao().getAll();
                return lc;
            }

            @Override
            protected void onPostExecute(List<Comptes> lc) {
                super.onPostExecute(lc);
                adapter.updateData(lc);
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