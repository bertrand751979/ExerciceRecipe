package com.example.exercicerecipe;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.exercicerecipe.models.EditIngredient;
import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.models.Recipe;

import java.util.List;

@Dao
public interface HitDao {
    @Query("SELECT * FROM Hit ")
    //LiveData<List<Hit>> getListRecipes();
    LiveData<List<Hit>> getFavItems();

    @Delete
    void deleteFavori(Hit hit);

    @Insert
    void insertFavori(Hit hit);

}
