package com.example.exercicerecipe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.exercicerecipe.R;
import com.example.exercicerecipe.models.EditIngredient;
import com.example.exercicerecipe.viewHolders.EditIngredientViewHolder;
import java.util.ArrayList;

public class EditIngredientAdapter extends RecyclerView.Adapter<EditIngredientViewHolder> {
    private ArrayList<EditIngredient> listEditIngredientAdapter = new ArrayList<>();


    public EditIngredientAdapter(){}

    public void setListEditIngredientAdapter(ArrayList<EditIngredient> listEditIngredientAdapter) {
        this.listEditIngredientAdapter = listEditIngredientAdapter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EditIngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_ingredients,parent,false);
        return new EditIngredientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EditIngredientViewHolder holder, int position) {
        holder.bind(listEditIngredientAdapter.get(position));
    }

    @Override
    public int getItemCount() {
        return listEditIngredientAdapter.size();
    }
}
