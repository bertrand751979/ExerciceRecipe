package com.example.exercicerecipe.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.models.Recipe;
import com.example.exercicerecipe.repository.RepositoryRecipe;

import java.util.ArrayList;

public class DescriptionActivityViewModel extends ViewModel {

    public void addToFavorite(Hit hit, Context context){
        RepositoryRecipe.getInstance().addFavori(hit,context);
    }
}
