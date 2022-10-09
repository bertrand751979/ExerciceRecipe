package com.example.exercicerecipe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicerecipe.GoToDescription;
import com.example.exercicerecipe.OnButtonDeleteClickedAction;
import com.example.exercicerecipe.R;
import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.viewHolders.FavoryViewHolder;
import com.example.exercicerecipe.viewHolders.RecipeViewHolder;

import java.util.ArrayList;

public class FavoryAdapter extends RecyclerView.Adapter<FavoryViewHolder> {
    private ArrayList<Hit> listFavoryAdapter = new ArrayList<>();
    private OnButtonDeleteClickedAction onButtonDeleteClickedAction;
    private GoToDescription goToDescription;

    public FavoryAdapter(OnButtonDeleteClickedAction onButtonDeleteClickedAction, GoToDescription goToDescription) {
        this.onButtonDeleteClickedAction = onButtonDeleteClickedAction;
        this.goToDescription = goToDescription;
    }

    public void setListFavoryAdapter(ArrayList<Hit> listFavoryAdapter) {
        this.listFavoryAdapter = listFavoryAdapter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_favory,parent,false);
        return new FavoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoryViewHolder holder, int position) {
        holder.bind(listFavoryAdapter.get(position),onButtonDeleteClickedAction,goToDescription );

    }

    @Override
    public int getItemCount() {
        return listFavoryAdapter.size();
    }





}
