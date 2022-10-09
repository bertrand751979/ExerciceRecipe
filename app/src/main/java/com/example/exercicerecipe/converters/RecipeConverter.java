package com.example.exercicerecipe.converters;

import androidx.room.TypeConverter;
import com.example.exercicerecipe.models.Recipe;
import com.google.gson.Gson;

public class RecipeConverter {
    @TypeConverter
    public static Recipe fromString (String value){
        //Type listType =  new TypeToken<String>(){}.getType();
        return new Gson().fromJson(value,Recipe.class);
    }

    @TypeConverter
    public static String fromRecipe (Recipe recipe){
        Gson gson = new Gson();
        //toJson retourne un string
        String json = gson.toJson(recipe);
        return json;
    }



}
