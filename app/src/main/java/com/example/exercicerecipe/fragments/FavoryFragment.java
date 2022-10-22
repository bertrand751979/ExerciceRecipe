package com.example.exercicerecipe.fragments;

import static com.example.exercicerecipe.activities.SearchActivity.RECIPE_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicerecipe.GoToDescription;
import com.example.exercicerecipe.OnButtonDeleteClickedAction;
import com.example.exercicerecipe.R;
import com.example.exercicerecipe.activities.DescriptionActivity;
import com.example.exercicerecipe.adapter.FavoryAdapter;
import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.repository.RepositoryRecipe;
import com.example.exercicerecipe.viewModel.FavoryFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoryFragment extends Fragment {
    private ArrayList<Hit> displayFavoriteList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FavoryAdapter favoryAdapter;
    private ImageView favImgEmpty;
    public FavoryFragmentViewModel favoryFragmentViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        favoryFragmentViewModel = new ViewModelProvider(this).get(FavoryFragmentViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favory, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_favory);
        favImgEmpty = view.findViewById(R.id.empty_list);
        setViewItem();
    }

    private void setViewItem() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        OnButtonDeleteClickedAction onButtonDeleteClickedAction = new OnButtonDeleteClickedAction() {
            @Override
            public void delete(Hit hit) {
                favoryFragmentViewModel.deleteRecipeFavory(hit, getContext());
                Toast.makeText(FavoryFragment.this.getContext(), "Supprimé", Toast.LENGTH_SHORT).show();
            }
        };
        GoToDescription goToDescription = new GoToDescription() {
            @Override
            public void description(Hit hit) {
                Intent intent = new Intent(FavoryFragment.this.getContext(), DescriptionActivity.class);
                intent.putExtra(RECIPE_KEY, hit);
                startActivity(intent);
                Toast.makeText(FavoryFragment.this.getContext(), "Vers description", Toast.LENGTH_SHORT).show();
            }
        };
        favoryAdapter = new FavoryAdapter(onButtonDeleteClickedAction, goToDescription);
        recyclerView.setAdapter(favoryAdapter);
        favoryFragmentViewModel.getFavoriteList(getContext()).observe(getViewLifecycleOwner(), new Observer<List<Hit>>() {
            @Override
            public void onChanged(List<Hit> hits) {
                favoryAdapter.setListFavoryAdapter(new ArrayList<>(hits));
                RepositoryRecipe.getInstance().myFavoriteListRecipe = (ArrayList<Hit>) hits;
                Toast.makeText(FavoryFragment.this.getContext(), "Nbre de favoris" + hits.size(), Toast.LENGTH_SHORT).show();
                if (hits.size() == 0) {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    EmptyListFragment llf = new EmptyListFragment();
                    ft.replace(R.id.fragment_container, llf);
                    ft.commit();
                    Toast.makeText(FavoryFragment.this.getContext(), "Pas de favoris", Toast.LENGTH_SHORT).show();
                }
                RepositoryRecipe.getInstance().recipeAlreadyFavory = (ArrayList<Hit>) hits;
                Log.d("favtaille", String.valueOf(RepositoryRecipe.getInstance().recipeAlreadyFavory.size()));
            }
        });
    }
}
