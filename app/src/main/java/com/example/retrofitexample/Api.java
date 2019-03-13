package com.example.retrofitexample;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.ArrayList;
import java.util.List;

public interface Api {

        String BASE_URL = "https://restcountries.eu/rest/v2/";

        @GET("all/?fields=name;")
        Call<ArrayList<Country>> getCountries();
}
