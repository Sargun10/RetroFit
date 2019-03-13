package com.example.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("name")
    private String name;
    @SerializedName("capital")
    private String capital;
    public Country(String name,String capital){
        this.name=name;
        this.capital=capital;
    }
    public String getName() {
        return name;
    }
    public String getCapital() {
        return capital;
    }


}
