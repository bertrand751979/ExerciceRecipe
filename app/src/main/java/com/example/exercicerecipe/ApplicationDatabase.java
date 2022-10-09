package com.example.exercicerecipe;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.exercicerecipe.converters.RecipeConverter;
import com.example.exercicerecipe.models.Hit;


@Database(entities = {Hit.class},version = 21)
@TypeConverters({ RecipeConverter.class})
public abstract class ApplicationDatabase extends RoomDatabase {
    private static ApplicationDatabase INSTANCE;
    public abstract HitDao getHitDao();
    public static synchronized ApplicationDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ApplicationDatabase.class, "recipe_app").build();
        }
        return INSTANCE;
    }





}
