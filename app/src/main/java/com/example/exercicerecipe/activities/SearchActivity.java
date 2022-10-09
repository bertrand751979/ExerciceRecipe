package com.example.exercicerecipe.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exercicerecipe.R;
import com.example.exercicerecipe.SearchActivityViewModel;
import com.example.exercicerecipe.adapter.EditIngredientAdapter;
import com.example.exercicerecipe.models.EditIngredient;
import com.example.exercicerecipe.models.Hit;
import com.example.exercicerecipe.models.Root;
import com.example.exercicerecipe.repository.RepositoryRecipe;
import com.example.exercicerecipe.retrofit.RecipeRetrofitApi;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
    private EditText myEditIngredient;
    private Button btnAddIngredient;
    private Button btnLaunchSearch;
    private Button btnClear;
    private EditIngredient editIngredient;
    public SearchActivityViewModel searchActivityViewModel;
    public static String RECIPE_KEY = "recipe_key";
    private EditIngredientAdapter editIngredientAdapter;
    private RecyclerView recyclerView;
    private ArrayList<List<String>> searchList = new ArrayList<List<String>>();
    private ArrayList<String> result = new ArrayList<>();
    private String ingredients ="";
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchActivityViewModel = new ViewModelProvider(this).get(SearchActivityViewModel.class);
        recyclerView = findViewById(R.id.recycler_view_ingredients);
        myEditIngredient = findViewById(R.id.search_edit_ingredients);
        btnClear = findViewById(R.id.btn_clear);
        btnLaunchSearch = findViewById(R.id.btn_launch_search_for_recipe);
        btnAddIngredient = findViewById(R.id.search_btn_search);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editIngredientAdapter.setListEditIngredientAdapter(RepositoryRecipe.getInstance().myListEditIngredient);
                RepositoryRecipe.getInstance().myListEditIngredient.clear();
                Toast.makeText(SearchActivity.this, "Effacé", Toast.LENGTH_SHORT).show();
            }
        });
        btnAddIngredient.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if(myEditIngredient.getText().toString().equalsIgnoreCase("")){
                }else{
                    EditIngredient editIngredient = new EditIngredient(myEditIngredient.getText().toString());
                    editIngredient.setIngredientSearching(myEditIngredient.getText().toString());
                    RepositoryRecipe.getInstance().myListEditIngredient.add(editIngredient);
                    editIngredientAdapter.setListEditIngredientAdapter(RepositoryRecipe.getInstance().myListEditIngredient);
                    editIngredientAdapter.notifyDataSetChanged();
                    myEditIngredient.setText("");
                    InputMethodManager inputManager = (InputMethodManager) getApplication().getSystemService(SearchActivity.this.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        });

        btnLaunchSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(EditIngredient editIngredient1 :RepositoryRecipe.getInstance().myListEditIngredient){
                    editIngredient1.getIngredientSearching();
                    ingredients = ingredients +","+editIngredient1.getIngredientSearching();
                    //Log.d("noms:",editIngredient1.getIngredientSearching());
                }
                //Log.d("result", ingredients);
                //Toast.makeText(SearchActivity.this, "ingredients"+result, Toast.LENGTH_SHORT).show();
                Log.d("laliste", String.valueOf(RepositoryRecipe.getInstance().myListEditIngredient.size()));
                observerIngredient();
                //Toast.makeText(SearchActivity.this, "taille"+RepositoryRecipe.getInstance().myListEditIngredient.size(), Toast.LENGTH_SHORT).show();
                callService();
            }
        });
        observer();
        setListView();
    }

    public void callService(){
        RecipeRetrofitApi.MyRecipeRetrofitService service = RecipeRetrofitApi.getInstance().getClient().create(RecipeRetrofitApi.MyRecipeRetrofitService.class);
        Call<Root> call= service.getRoot(ingredients,"e55977b4","823b1436ab001e046babd4840d32ac14");
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                updateView(response);
            }
            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Toast.makeText(SearchActivity.this, "NO RESPONSE", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateView(Response<Root> response) {
        if (response.isSuccessful() && response.body().getHits() != null) {
            RepositoryRecipe.getInstance().myListRecipe = response.body().getHits();
            Toast.makeText(this, "taille"+RepositoryRecipe.getInstance().myListRecipe.size(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SearchActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(SearchActivity.this, "Reponse  du serveur", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "ERROR 404", Toast.LENGTH_SHORT).show();
        }
    }

    public void setListView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
        //editIngredientAdapter = new EditIngredientAdapter(RepositoryRecipe.getInstance().getMyListEditIngredient());
        editIngredientAdapter = new EditIngredientAdapter();
        recyclerView.setAdapter(editIngredientAdapter);
    }

    public void observer(){
        searchActivityViewModel.recipeLiveData.observe(this, new Observer<List<Hit>>() {
            @Override
            public void onChanged(List<Hit> hits) {
                //RepositoryRecipe.getInstance().myListRecipe = (ArrayList<Hit>) hits;
            }
        });
    }

    public void observerIngredient(){
        searchActivityViewModel.editIngredientLiveData.observe(this, new Observer<List<EditIngredient>>() {
            @Override
            public void onChanged(List<EditIngredient> editIngredients) {
                RepositoryRecipe.getInstance().myListEditIngredient = (ArrayList<EditIngredient>) editIngredients;
            }
        });
    }



}
