package com.example.exercicerecipe.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class Hit implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public long identifier;
    @ColumnInfo(name = "recipe")
    public Recipe recipe;

    public Hit(long identifier, Recipe recipe) {
        this.identifier = identifier;
        this.recipe = recipe;
    }

    public Hit(){}
    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }
}
