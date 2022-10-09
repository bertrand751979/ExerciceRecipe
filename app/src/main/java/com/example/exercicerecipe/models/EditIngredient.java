package com.example.exercicerecipe.models;

public class EditIngredient {
    private String ingredientSearching;

    public EditIngredient(String ingredientSearching) {
        this.ingredientSearching = ingredientSearching;
    }


    public String getIngredientSearching() {
        return ingredientSearching;
    }

    public void setIngredientSearching(String ingredientSearching) {
        this.ingredientSearching = ingredientSearching;
    }
}
