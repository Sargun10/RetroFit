package com.example.retrofitexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Country> countryArrayList;
    public CountryAdapter(ArrayList<Country> rvCountries) {
        this.countryArrayList = rvCountries;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_view_item,viewGroup,false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            CountryViewHolder countryViewHolder = (CountryViewHolder) viewHolder;
            countryViewHolder.tvName.setText(countryArrayList.get(i).getName());
            countryViewHolder.tvCapitalName.setText(countryArrayList.get(i).getCapital());


    }

    @Override
    public int getItemCount() {
        return countryArrayList.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvCapitalName;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvCountryName);
            tvCapitalName=itemView.findViewById(R.id.tvCapitalName);
        }

    }
}
