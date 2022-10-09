package com.example.exercicerecipe.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.repository.RepositoryRecipe;

import java.util.List;

public class FavoryFragmentViewModel extends ViewModel {

    public  LiveData<List<Hit>> getFavoriteList(Context context){
        return RepositoryRecipe.getInstance().getFavoriteRecipes(context);
    }

    public void deleteRecipeFavory(Hit hit, Context context){
        RepositoryRecipe.getInstance().deleteFav(hit, context);
    }





}
