package com.example.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {



    RecyclerView rvCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCountries = findViewById(R.id.rvCountries);
        rvCountries.setLayoutManager(new LinearLayoutManager(this));
        getHeroes();
    }

    private void getHeroes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<ArrayList<Country>> call = api.getCountries();
        call.enqueue(new Callback<ArrayList<Country>>() {
            @Override
            public void onResponse(Call<ArrayList<Country>> call, Response<ArrayList<Country>> response) {
                ArrayList<Country> arrayList = response.body();
                for(int i=0;i<arrayList.size();i++){
                    Log.d("Data",arrayList.get(i).getName());
                }
                rvCountries.setAdapter(new CountryAdapter(arrayList));
            }

            @Override
            public void onFailure(Call<ArrayList<Country>> call, Throwable t) {

            }
        });
    }
}
