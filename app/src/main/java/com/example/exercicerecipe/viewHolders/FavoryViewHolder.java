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
    private TextView vhFavRecipeTitle;
    private TextView vhFavRecipeIngredient;
    private TextView vhFavRecipeNote;
    private ImageView vhFavRecipePhoto;
    private LinearLayout vhLinearLayout;
    private ImageView vhBtnCancel;

    public FavoryViewHolder(@NonNull View view) {
        super(view);
        vhFavRecipeTitle = view.findViewById(R.id.raw_fav_title_recipe);
        vhFavRecipeIngredient = view.findViewById(R.id.raw_fav_ingredients_recipe);
        vhFavRecipePhoto = view.findViewById(R.id.raw_fav_photo_recipe);
        vhLinearLayout = view.findViewById(R.id.raw_fav_linear_layout);
        vhFavRecipeNote = view.findViewById(R.id.raw_fav_rate_recipe);
        vhBtnCancel = view.findViewById(R.id.raw_fav_delete);
    }

    public TextView getVhFavRecipeTitle() {
        return vhFavRecipeTitle;
    }

    public void setVhFavRecipeTitle(TextView vhFavRecipeTitle) {
        this.vhFavRecipeTitle = vhFavRecipeTitle;
    }

    public TextView getVhFavRecipeIngredient() {
        return vhFavRecipeIngredient;
    }

    public void setVhFavRecipeIngredient(TextView vhFavRecipeIngredient) {
        this.vhFavRecipeIngredient = vhFavRecipeIngredient;
    }

    public TextView getVhFavRecipeNote() {
        return vhFavRecipeNote;
    }

    public void setVhFavRecipeNote(TextView vhFavRecipeNote) {
        this.vhFavRecipeNote = vhFavRecipeNote;
    }

    public ImageView getVhFavRecipePhoto() {
        return vhFavRecipePhoto;
    }

    public void setVhFavRecipePhoto(ImageView vhFavRecipePhoto) {
        this.vhFavRecipePhoto = vhFavRecipePhoto;
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
        vhFavRecipeTitle.setText(hit.getRecipe().getLabel());
        if(vhFavRecipePhoto!=null){
        Glide.with(vhFavRecipePhoto.getContext())
                .load(hit.getRecipe().getImage())
                .into(vhFavRecipePhoto);}
        else{
            vhFavRecipePhoto.setImageResource(R.drawable.ic_error);
        }
        vhLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDescription.description(hit);
            }
        });

        if(hit.getRecipe().getIngredientLines().size() == 0){
            vhFavRecipeIngredient.setText("");
        }if(hit.getRecipe().getIngredientLines().size() > 0){}
        vhFavRecipeIngredient.setText(hit.getRecipe().getIngredientLines().get(0));
    }
}
