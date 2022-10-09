package com.example.exercicerecipe.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.repository.RepositoryRecipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeDisplayFragmentViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Hit>> myRecipeList = new MutableLiveData<>();
    public LiveData<ArrayList<Hit>> recipeLiveData = myRecipeList;


    public void toPostMyItemsList(){
        myRecipeList.postValue(RepositoryRecipe.getInstance().getMyListRecipe());
    }










}
