package com.example.exercicerecipe.fragments;

import static com.example.exercicerecipe.activities.SearchActivity.RECIPE_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicerecipe.GoToDescription;
import com.example.exercicerecipe.R;
import com.example.exercicerecipe.activities.DescriptionActivity;
import com.example.exercicerecipe.adapter.RecipeAdapter;
import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.models.Ingredient;
import com.example.exercicerecipe.models.Recipe;
import com.example.exercicerecipe.repository.RepositoryRecipe;
import com.example.exercicerecipe.viewModel.RecipeDisplayFragmentViewModel;

import java.util.ArrayList;
import java.util.List;


public class RecipeDisplayFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecipeAdapter recipeAdapter;
    public RecipeDisplayFragmentViewModel recipeDisplayFragmentViewModel;
    private ArrayList<Hit> displayRecipe = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayRecipe = RepositoryRecipe.getInstance().myListRecipe;
        recipeDisplayFragmentViewModel = new ViewModelProvider(this).get(RecipeDisplayFragmentViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recipe_display,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        setViewItem();
    }

    private void setViewItem() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        GoToDescription goToDescription = new GoToDescription() {
            @Override
            public void description(Hit hit) {
                Intent intent = new Intent(RecipeDisplayFragment.this.getContext(), DescriptionActivity.class);
                intent.putExtra(RECIPE_KEY,hit);
                startActivity(intent);
                Toast.makeText(RecipeDisplayFragment.this.getContext(), "Vers description", Toast.LENGTH_SHORT).show();
            }
        };

        recipeAdapter = new RecipeAdapter(goToDescription);
        recyclerView.setAdapter(recipeAdapter);
        recipeDisplayFragmentViewModel.recipeLiveData.observe(getViewLifecycleOwner(), new Observer<List<Hit>>() {
            @Override
            public void onChanged(List<Hit> hits) {
                recipeAdapter.setListRecipeAdapter(new ArrayList<>(hits));
            }
        });
        recipeDisplayFragmentViewModel.toPostMyItemsList();
    }
}
