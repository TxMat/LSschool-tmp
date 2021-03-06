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

    private List<Comptes> mData;
    private final LayoutInflater mInflater;

    public ComptesAdapter(List<Comptes> mData, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = mData;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.account_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comptes cpt = mData.get(position);
        holder.tv.setText(cpt.getPrenom() + " " + cpt.getName());




        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ListeExercicesActivity.class);
            intent.putExtra(ListeExercicesActivity.NOM_KEY, cpt.getPrenom());
            v.getContext().startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void updateData(List<Comptes> lc) {
        mData = lc;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tvItem);
        }
    }
}