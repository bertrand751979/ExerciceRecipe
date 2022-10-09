package com.example.exercicerecipe.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.exercicerecipe.GoToDescription;
import com.example.exercicerecipe.R;
import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.models.Root;

public class RecipeViewHolder extends RecyclerView.ViewHolder {
    private TextView vhRecipeTitle;
    private TextView vhRecipeIngredient;
    private TextView vhRecipeNote;
    private ImageView vhRecipePhoto;
    private LinearLayout vhLinearLayout;

    public RecipeViewHolder(@NonNull View view) {
        super(view);
        vhRecipeTitle = view.findViewById(R.id.raw_title_recipe);
        vhRecipeIngredient = view.findViewById(R.id.raw_ingredients_recipe);
        vhRecipePhoto = view.findViewById(R.id.raw_photo_recipe);
        vhLinearLayout = view.findViewById(R.id.raw_linear_layout);

        vhRecipeNote = view.findViewById(R.id.raw_rate_recipe);
    }

    public TextView getVhRecipeTitle() {
        return vhRecipeTitle;
    }

    public void setVhRecipeTitle(TextView vhRecipeTitle) {
        this.vhRecipeTitle = vhRecipeTitle;
    }

    public TextView getVhRecipeIngredient() {
        return vhRecipeIngredient;
    }

    public void setVhRecipeIngredient(TextView vhRecipeIngredient) {
        this.vhRecipeIngredient = vhRecipeIngredient;
    }

    public ImageView getVhRecipePhoto() {
        return vhRecipePhoto;
    }

    public void setVhRecipePhoto(ImageView vhRecipePhoto) {
        this.vhRecipePhoto = vhRecipePhoto;
    }

    public LinearLayout getVhLinearLayout() {
        return vhLinearLayout;
    }

    public void setVhLinearLayout(LinearLayout vhLinearLayout) {
        this.vhLinearLayout = vhLinearLayout;
    }

    public TextView getVhRecipeNote() {
        return vhRecipeNote;
    }

    public void setVhRecipeNote(TextView vhRecipeNote) {
        this.vhRecipeNote = vhRecipeNote;
    }

    public void bind(Hit hit, GoToDescription goToDescription){
        vhRecipeTitle.setText(hit.getRecipe().getLabel());
        if(vhRecipePhoto!=null){
        Glide.with(vhRecipePhoto.getContext())
                        .load(hit.getRecipe().getImage())
                                .into(vhRecipePhoto);}
        else{
            vhRecipePhoto.setImageResource(R.drawable.ic_error);
        }


        vhLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDescription.description(hit);
            }
        });
    }










}
