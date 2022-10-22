package com.example.exercicerecipe.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.exercicerecipe.repository.RepositoryRecipe;

import java.io.Serializable;
public class Ingredient implements Serializable {
        public String text;
        public double quantity;
        public String measure;
        public String food;
        public double weight;
        public String foodCategory;
        public String foodId;
        public String image;

        public Ingredient(String text, double quantity, String measure, String food, double weight, String foodCategory, String foodId, String image) {
                this.text = text;
                this.quantity = quantity;
                this.measure = measure;
                this.food = food;
                this.weight = weight;
                this.foodCategory = foodCategory;
                this.foodId = foodId;
                this.image = image;
        }

        public String getText() {
                return text;
        }

        public void setText(String text) {
                this.text = text;
        }

        public double getQuantity() {
                return quantity;
        }

        public void setQuantity(double quantity) {
                this.quantity = quantity;
        }

        public String getMeasure() {
                return measure;
        }

        public void setMeasure(String measure) {
                this.measure = measure;
        }

        public String getFood() {
                return food;
        }

        public void setFood(String food) {
                this.food = food;
        }

        public double getWeight() {
                return weight;
        }

        public void setWeight(double weight) {
                this.weight = weight;
        }

        public String getFoodCategory() {
                return foodCategory;
        }

        public void setFoodCategory(String foodCategory) {
                this.foodCategory = foodCategory;
        }

        public String getFoodId() {
                return foodId;
        }

        public void setFoodId(String foodId) {
                this.foodId = foodId;
        }

        public String getImage() {
                return image;
        }

        public void setImage(String image) {
                this.image = image;
        }



}
