package com.example.exercicerecipe.viewHolders;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.exercicerecipe.GoToDescription;
import com.example.exercicerecipe.OnButtonClearClickedAction;
import com.example.exercicerecipe.OnButtonDeleteClickedAction;
import com.example.exercicerecipe.R;
import com.example.exercicerecipe.fragments.FavoryFragment;
import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.repository.RepositoryRecipe;

public class FavoryViewHolder extends RecyclerView.ViewHolder {
    private TextView vhRecipeTitle;
    private TextView vhRecipeIngredient;
    private TextView vhRecipeNote;
    private ImageView vhRecipePhoto;
    private LinearLayout vhLinearLayout;
    private ImageView vhBtnCancel;

    public FavoryViewHolder(@NonNull View view) {
        super(view);
        vhRecipeTitle = view.findViewById(R.id.raw_fav_title_recipe);
        vhRecipeIngredient = view.findViewById(R.id.raw_fav_ingredients_recipe);
        vhRecipePhoto = view.findViewById(R.id.raw_fav_photo_recipe);
        vhLinearLayout = view.findViewById(R.id.raw_fav_linear_layout);
        vhRecipeNote = view.findViewById(R.id.raw_fav_rate_recipe);
        vhBtnCancel = view.findViewById(R.id.raw_fav_delete);
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

    public TextView getVhRecipeNote() {
        return vhRecipeNote;
    }

    public void setVhRecipeNote(TextView vhRecipeNote) {
        this.vhRecipeNote = vhRecipeNote;
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



    public void bind(Hit hit, OnButtonDeleteClickedAction onButtonDeleteClickedAction, GoToDescription goToDescription){
        vhBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonDeleteClickedAction.delete(hit);
            }
        });

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
