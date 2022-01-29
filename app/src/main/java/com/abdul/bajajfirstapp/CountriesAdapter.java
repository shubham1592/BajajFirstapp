package com.abdul.bajajfirstapp;


import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


//step 1 -- implemented the methods
//step 2 - created a class CountriesViewHolder [import]
//step 3 - extend CountriesViewHolder with  RecyclerView.ViewHolder
//4 -- create constructor for CountriesViewHolder
//5 --rv_item_row_plank represents one row in the recycler view
//6 --implemented onCreateViewHolder
//7 -- in CountriesViewHolder i got the handle of textview
//8 -- i passed the array from recycleractvity to the countriesadapter
//9 implemented getItemCount
//10 -- onBindViewHolder -- set the country on to the textview

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> {

    String[] mCountries;
    public CountriesAdapter(String[] countries) {
        mCountries = countries;
    }

    @NonNull
    @Override //niket -- inflate rows [buys the wooden planks]
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowPlank = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_row_plank,parent,false);
        return new CountriesViewHolder(rowPlank);
    }

    @Override //avichal -- handwriting --write on the plank
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {
        holder.rowTextView.setText(mCountries[position]);
    }

    @Override //vijay -- keep the count of no of items in the array
    public int getItemCount() {
        return mCountries.length;
    }

    //box holding the planks -- harshit
    class  CountriesViewHolder extends RecyclerView.ViewHolder{
        TextView rowTextView;

        public CountriesViewHolder(@NonNull View itemView) {
            super(itemView);
            rowTextView = itemView.findViewById(R.id.tvRow);
        }
    }
}
