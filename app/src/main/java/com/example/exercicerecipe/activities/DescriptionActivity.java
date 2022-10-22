package com.example.exercicerecipe.activities;

import static com.example.exercicerecipe.activities.SearchActivity.RECIPE_KEY;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.exercicerecipe.R;
import com.example.exercicerecipe.fragments.EmptyListFragment;
import com.example.exercicerecipe.fragments.FavoryFragment;
import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.repository.RepositoryRecipe;
import com.example.exercicerecipe.viewModel.DescriptionActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class DescriptionActivity extends AppCompatActivity {
    private ImageView descImage;
    private TextView descTitle;
    private TextView descIngredients;
    private TextView descTotalTime;
    private TextView descDietLabel;
    private TextView descHyperlink;
    public Hit hit;
    private ImageView btnFavoryStar;
    public DescriptionActivityViewModel descriptionActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        descriptionActivityViewModel =new ViewModelProvider(this).get(DescriptionActivityViewModel.class);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        hit = (Hit) getIntent().getSerializableExtra(RECIPE_KEY);
        btnFavoryStar = findViewById(R.id.btn_desc_star_empty);
        Toast.makeText(this, "OK"+RepositoryRecipe.getInstance().getRecipeAlreadyFavory().size(), Toast.LENGTH_SHORT).show();
        descImage = findViewById(R.id.desc_photo_recipe);
        descTitle = findViewById(R.id.desc_title_recipe);
        descIngredients = findViewById(R.id.desc_ingredients_recipe);
        descTotalTime = findViewById(R.id.desc_hour_recipe);
        descDietLabel = findViewById(R.id.desc_rate_recipe);
        descHyperlink = findViewById(R.id.desc_link_to_detail);
        checkIfFavoriteRecipe();
        btnFavoryStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnFavoryStar.setImageResource(R.drawable.ic_full_star);
                setOnTimeToFavorite();
                refreshFavoriteList();
            }
        });

        Glide.with(this)
                .load(hit.getRecipe().getImage())
                .into(descImage);
        descTitle.setText(hit.getRecipe().getLabel());
        descIngredients.setText(RepositoryRecipe.getInstance().displayIngredients());
        descTotalTime.setText(String.valueOf(hit.getRecipe().getTotalTime()));
       if(hit.getRecipe().getDietLabels().size() == 0){
           descDietLabel.setText("Pas d'indice");
       }
       if(hit.getRecipe().getDietLabels().size()>0){
           descDietLabel.setText(hit.getRecipe().getDietLabels().get(0));
       }
        if(hit.getRecipe().getUrl() == null){
            descHyperlink.setText("");
        }else{
            descHyperlink.setText(hit.getRecipe().getUrl());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshFavoriteList();
        checkIfFavoriteRecipe();
    }

    private void checkIfFavoriteRecipe(){
        if(RepositoryRecipe.getInstance().isFavorite(hit)==true){
            btnFavoryStar.setImageResource(R.drawable.ic_full_star);
        }else{
            btnFavoryStar.setImageResource(R.drawable.ic_empty_star_);
        }
    }

    private void refreshFavoriteList(){
        descriptionActivityViewModel.getFavoriteList(DescriptionActivity.this).observe( this,new Observer<List<Hit>>() {
            @Override
            public void onChanged(List<Hit> hits) {
                RepositoryRecipe.getInstance().myFavoriteListRecipe = (ArrayList<Hit>) hits;
            }
        });
    }


    private  void setOnTimeToFavorite(){
        descriptionActivityViewModel.getFavoriteList(DescriptionActivity.this).observe( this,new Observer<List<Hit>>() {
            @Override
            public void onChanged(List<Hit> hits) {
                RepositoryRecipe.getInstance().myFavoriteListRecipe = (ArrayList<Hit>) hits;
                if(RepositoryRecipe.getInstance().isFavorite(hit)==true){
                    Toast.makeText(DescriptionActivity.this, "Deja Favori", Toast.LENGTH_SHORT).show();
                }else{
                    descriptionActivityViewModel.addToFavorite(hit,DescriptionActivity.this);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();}
        return super.onOptionsItemSelected(item);
    }
}
