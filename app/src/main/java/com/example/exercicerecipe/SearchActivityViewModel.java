package com.example.exercicerecipe;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.exercicerecipe.models.EditIngredient;
import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.repository.RepositoryRecipe;

import java.util.List;

public class SearchActivityViewModel extends ViewModel {
    //public LiveData<List<Hit>> getBeginingListfavoriteLiveData (Context context){
      //  return RepositoryRecipe.getInstance().getListRecipe(context);

    private MutableLiveData<List<Hit>> myRecipeList = new MutableLiveData<>();
    public LiveData<List<Hit>> recipeLiveData = myRecipeList;

    private MutableLiveData<List<EditIngredient>> myListEditIngredient = new MutableLiveData<>();
    public LiveData<List<EditIngredient>> editIngredientLiveData = myListEditIngredient;


    public void toPostMyRecipeList(){
        myRecipeList.postValue(RepositoryRecipe.getInstance().getMyListRecipe());
        //myItemsList.postValue(RepositoryBook.getInstance().getMyBookList());
    }


}
