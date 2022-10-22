package com.example.exercicerecipe.repository;

import android.content.Context;
import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import com.example.exercicerecipe.ApplicationDatabase;
import com.example.exercicerecipe.R;
import com.example.exercicerecipe.models.EditIngredient;
import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.models.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class RepositoryRecipe {
    public ArrayList<Hit> myListRecipe = new ArrayList<>();
    public ArrayList<Hit> myFavoriteListRecipe = new ArrayList<>();
    public ArrayList<EditIngredient> myListEditIngredient = new ArrayList<>();
    public ArrayList<Recipe> ingredientListDisplay = new ArrayList<>();
    public String allIngredientsText ="";
    public String allDietLabel ="";
    public ArrayList<Hit> recipeAlreadyFavory = new ArrayList<>();

    private RepositoryRecipe(){}
    private static RepositoryRecipe INSTANCE = null;
    public static RepositoryRecipe getInstance(){
        if (INSTANCE == null){
            INSTANCE = new RepositoryRecipe();
        }
        return INSTANCE;
    }

    public ArrayList<Hit> getMyListRecipe() {
        return myListRecipe;
    }

    public void setMyListRecipe(ArrayList<Hit> myListRecipe) {
        this.myListRecipe = myListRecipe;
    }

    public ArrayList<Hit> getMyFavoriteListRecipe() {
        return myFavoriteListRecipe;
    }

    public void setMyFavoriteListRecipe(ArrayList<Hit> myFavoriteListRecipe) {
        this.myFavoriteListRecipe = myFavoriteListRecipe;
    }

    public ArrayList<EditIngredient> getMyListEditIngredient() {
        return myListEditIngredient;
    }

    public void setMyListEditIngredient(ArrayList<EditIngredient> myListEditIngredient) {
        this.myListEditIngredient = myListEditIngredient;
    }

    public ArrayList<Hit> getRecipeAlreadyFavory() {
        return recipeAlreadyFavory;
    }

    public void setRecipeAlreadyFavory(ArrayList<Hit> recipeAlreadyFavory) {
        this.recipeAlreadyFavory = recipeAlreadyFavory;
    }

    public ArrayList<Recipe> getIngredientListDisplay() {
        return ingredientListDisplay;
    }

    public void setIngredientListDisplay(ArrayList<Recipe> ingredientListDisplay) {
        this.ingredientListDisplay = ingredientListDisplay;
    }

    public void addIngredients(EditIngredient editIngredient , Context context){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                RepositoryRecipe.getInstance().myListEditIngredient.add(editIngredient);
            }
        });
    }

    public void deleteFav(Hit hit, Context context){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ApplicationDatabase.getInstance(context).getHitDao().deleteFavori(hit);
            }
        });
    }

    public void addFavori(Hit hit, Context context){
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ApplicationDatabase.getInstance(context).getHitDao().insertFavori(hit);
            }
        });
    }

    public boolean isFavorite(Hit recipeSelected){
        boolean result=  false;
        for(Hit recipefav:myFavoriteListRecipe){
            if(recipefav.getRecipe().getUrl().equals(recipeSelected.getRecipe().getUrl())) {
                result = true;
            }
        }
        return result;
    }




    /*public boolean isFavorite(Hit recipeSelected){
        boolean result =false;
        for(Hit recipefav:recipeAlreadyFavory ){
                if(recipeSelected.getRecipe().getLabel().equals(recipefav.getRecipe().getLabel())){
                    result = true;
                    }
                }
        return result;
    }*/


    public LiveData<List<Hit>> getFavoriteRecipes(Context context){
        return ApplicationDatabase.getInstance(context).getHitDao().getFavItems();
    }

    public String displayIngredients(){
        for(Hit hit2 : RepositoryRecipe.getInstance().myListRecipe){
            allIngredientsText=allIngredientsText+""+hit2.getRecipe().getIngredients().get(0).getText();
        }
        return allIngredientsText;
    }




}
