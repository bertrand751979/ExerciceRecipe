package com.example.exercicerecipe.retrofit;



import com.example.exercicerecipe.models.Recipe;
import com.example.exercicerecipe.models.Root;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RecipeRetrofitApi {
    public interface MyRecipeRetrofitService {
        @GET("search")
        Call<Root> getRoot(@Query("q")String q, @Query("app_id")String app_id, @Query("app_key")String app_key	);
    }
    private final static String BASE_URL="https://api.edamam.com/";
    //private final static String BASE_URL = "https://api.edamam.com/api/recipes/v2";
    private static RecipeRetrofitApi INSTANCE = null;
    private RecipeRetrofitApi(){}
    public static RecipeRetrofitApi getInstance(){
        if (INSTANCE == null){
            INSTANCE = new RecipeRetrofitApi();
        }
        return INSTANCE;
    }
    public Retrofit getClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }


}
