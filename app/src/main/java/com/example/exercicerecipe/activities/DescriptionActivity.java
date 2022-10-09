package com.example.exercicerecipe.activities;

import static com.example.exercicerecipe.activities.SearchActivity.RECIPE_KEY;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.exercicerecipe.R;
import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.models.Ingredient;
import com.example.exercicerecipe.models.Recipe;
import com.example.exercicerecipe.repository.RepositoryRecipe;
import com.example.exercicerecipe.viewModel.DescriptionActivityViewModel;

public class DescriptionActivity extends AppCompatActivity {
    private ImageView descImage;
    private TextView descTitle;
    private TextView descIngredients;
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
        descImage = findViewById(R.id.desc_photo_recipe);
        descTitle = findViewById(R.id.desc_title_recipe);
        descIngredients = findViewById(R.id.desc_ingredients_recipe);
        if(RepositoryRecipe.getInstance().isFavorite(hit)){
            btnFavoryStar.setImageResource(R.drawable.ic_full_star);
        }else{
            btnFavoryStar.setImageResource(R.drawable.ic_empty_star_);
        }


        btnFavoryStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descriptionActivityViewModel.addToFavorite(hit,DescriptionActivity.this);
                btnFavoryStar.setImageResource(R.drawable.ic_full_star);
                Toast.makeText(DescriptionActivity.this, "Ajouté aux favoris"+RepositoryRecipe.getInstance().myFavoriteListRecipe.size(), Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(this)
                .load(hit.getRecipe().getImage())
                .into(descImage);
        descTitle.setText(hit.getRecipe().getLabel());
        descIngredients.setText(hit.getRecipe().getIngredientLines().get(0));
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();}
        return super.onOptionsItemSelected(item);
    }

}
