package com.example.exercicerecipe.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicerecipe.R;
import com.example.exercicerecipe.models.EditIngredient;

public class EditIngredientViewHolder extends RecyclerView.ViewHolder {
    private TextView vhEditIngredient;

    public EditIngredientViewHolder(@NonNull View view) {
        super(view);
        vhEditIngredient = view.findViewById(R.id.raw_ingredient_name);
    }

    public TextView getVhEditIngredient() {
        return vhEditIngredient;
    }

    public void setVhEditIngredient(TextView vhEditIngredient) {
        this.vhEditIngredient = vhEditIngredient;
    }

    public void bind(EditIngredient editIngredient){
        vhEditIngredient.setText(editIngredient.getIngredientSearching());

    }
}
