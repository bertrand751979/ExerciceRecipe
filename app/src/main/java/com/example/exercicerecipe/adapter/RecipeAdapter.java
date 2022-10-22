package com.example.exercicerecipe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.exercicerecipe.GoToDescription;
import com.example.exercicerecipe.R;
import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.viewHolders.RecipeViewHolder;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {
    private ArrayList<Hit> listRecipeAdapter = new ArrayList<>();
    private GoToDescription goToDescription;

    public RecipeAdapter(GoToDescription goToDescription) {
        this.goToDescription = goToDescription;
    }

    public void setListRecipeAdapter(ArrayList<Hit> listRecipeAdapter) {
        this.listRecipeAdapter = listRecipeAdapter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_recipe,parent,false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.bind(listRecipeAdapter.get(position),goToDescription);
    }

    @Override
    public int getItemCount() {
        return listRecipeAdapter.size();
    }
}
