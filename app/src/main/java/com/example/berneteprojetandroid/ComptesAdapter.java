package com.example.berneteprojetandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.berneteprojetandroid.bdd.Comptes;

import java.util.ArrayList;
import java.util.List;

public class ComptesAdapter extends RecyclerView.Adapter<ComptesAdapter.ViewHolder> {

    private ArrayList<Comptes> mData;

    public ComptesAdapter(ArrayList<Comptes> comptes) {
        this.mData = comptes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nomEleveTextView;

        public ViewHolder(View itemView){
            super(itemView);
        }
    }

    private List<Comptes> listeCompte;

    public void EleveAdapter(List<Comptes> liste){
        listeCompte = liste;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ComptesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.account_row, parent, false);

        // Return a new holder instance
        return new ViewHolder(contactView);
    }



    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ComptesAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Comptes eleve = listeCompte.get(position);

        // Set item views based on your views and data model
        TextView nomTextView = holder.nomEleveTextView;

        nomTextView.setText(eleve.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("eleve", eleve);
                v.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listeCompte.size();
    }

}