package com.example.exercicerecipe.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
@Entity
public class Recipe implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "uri")
    public String uri;

    @ColumnInfo(name = "label")
    public String label;

    @ColumnInfo(name = "image")
    public String image;

    @ColumnInfo(name = "source")
    public String source;

    @ColumnInfo(name = "url")
    public String url;

    @ColumnInfo(name = "shareAs")
    public String shareAs;
    //@JsonProperty("yield")
    public double myyield;

    @ColumnInfo(name = "dietLabels")
    public ArrayList<String> dietLabels;

    @ColumnInfo(name = "healthLabels")
    public ArrayList<String> healthLabels;

    @ColumnInfo(name = "cautions")
    public ArrayList<String> cautions;

    @ColumnInfo(name = "ingredientsLines")
    public ArrayList<String> ingredientLines;

    @ColumnInfo(name = "ingredients")
    public ArrayList<Ingredient> ingredients;

    @ColumnInfo(name = "calories")
    public double calories;

    @ColumnInfo(name = "totalWeight")
    public double totalWeight;

    @ColumnInfo(name = "totalTime")
    public double totalTime;

    @ColumnInfo(name = "cusineType")
    public ArrayList<String> cuisineType;

    @ColumnInfo(name = "mealType")
    public ArrayList<String> mealType;

    @ColumnInfo(name = "dishType")
    public ArrayList<String> dishType;

    @ColumnInfo(name = "totalNutrients")
    public TotalNutrients totalNutrients;

    @ColumnInfo(name = "totalDaily")
    public TotalDaily totalDaily;

    @ColumnInfo(name = "digest")
    public ArrayList<Digest> digest;


    public Recipe(){}
    public Recipe(String uri, String label, String image, String source, String url, String shareAs,
                  ArrayList<String> dietLabels, ArrayList<String> healthLabels,
                  ArrayList<String> cautions, ArrayList<String> ingredientLines, ArrayList<Ingredient> ingredients,
                  double calories, double totalWeight, double totalTime, ArrayList<String> cuisineType,
                  ArrayList<String> mealType, ArrayList<String> dishType, TotalNutrients totalNutrients,
                  TotalDaily totalDaily, ArrayList<Digest> digest) {
        this.uri = uri;
        this.label = label;
        this.image = image;
        this.source = source;
        this.url = url;
        this.shareAs = shareAs;
        //this.myyield = myyield;
        this.dietLabels = dietLabels;
        this.healthLabels = healthLabels;
        this.cautions = cautions;
        this.ingredientLines = ingredientLines;
        this.ingredients = ingredients;
        this.calories = calories;
        this.totalWeight = totalWeight;
        this.totalTime = totalTime;
        this.cuisineType = cuisineType;
        this.mealType = mealType;
        this.dishType = dishType;
        this.totalNutrients = totalNutrients;
        this.totalDaily = totalDaily;
        this.digest = digest;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShareAs() {
        return shareAs;
    }

    public void setShareAs(String shareAs) {
        this.shareAs = shareAs;
    }

    /*public double getMyyield() {
        return myyield;
    }*/

    /*public void setMyyield(double myyield) {
        this.myyield = myyield;
    }*/

    public ArrayList<String> getDietLabels() {
        return dietLabels;
    }

    public void setDietLabels(ArrayList<String> dietLabels) {
        this.dietLabels = dietLabels;
    }

    public ArrayList<String> getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(ArrayList<String> healthLabels) {
        this.healthLabels = healthLabels;
    }

    public ArrayList<String> getCautions() {
        return cautions;
    }

    public void setCautions(ArrayList<String> cautions) {
        this.cautions = cautions;
    }

    public ArrayList<String> getIngredientLines() {
        return ingredientLines;
    }

    public void setIngredientLines(ArrayList<String> ingredientLines) {
        this.ingredientLines = ingredientLines;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public ArrayList<String> getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(ArrayList<String> cuisineType) {
        this.cuisineType = cuisineType;
    }

    public ArrayList<String> getMealType() {
        return mealType;
    }

    public void setMealType(ArrayList<String> mealType) {
        this.mealType = mealType;
    }

    public ArrayList<String> getDishType() {
        return dishType;
    }

    public void setDishType(ArrayList<String> dishType) {
        this.dishType = dishType;
    }

    public TotalNutrients getTotalNutrients() {
        return totalNutrients;
    }

    public void setTotalNutrients(TotalNutrients totalNutrients) {
        this.totalNutrients = totalNutrients;
    }

    public TotalDaily getTotalDaily() {
        return totalDaily;
    }

    public void setTotalDaily(TotalDaily totalDaily) {
        this.totalDaily = totalDaily;
    }

    public ArrayList<Digest> getDigest() {
        return digest;
    }

    public void setDigest(ArrayList<Digest> digest) {
        this.digest = digest;
    }
}
