package com.abdul.bajajfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

public class RecyclerActivity extends AppCompatActivity {
    public  static String TAG = RecyclerActivity.class.getSimpleName();
    String[] countries = new String[]{"Russia","Ukraine","UK","Germany","US","China"}; //data = plug

    @Override //memory is getting allocated in RAM
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG,"creating");

        setContentView(R.layout.activity_recycler);   //inflating activity_recyclerview layoutinflater
        RecyclerView countriesRecyclerView = findViewById(R.id.countriesRview); //socket
        CountriesAdapter adapter = new CountriesAdapter(countries);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        countriesRecyclerView.setLayoutManager(layoutManager);
        countriesRecyclerView.setAdapter(adapter);
    }

    @Override //the actvity is visible to the user
    protected void onStart() {
        super.onStart();
        Log.w(TAG,"starting");
        int j = 1;
        for(int i=1; i<10; i++){
           j = i*5 +10 -13;
        }
        //throw new NullPointerException();

    }

    @Override  //activity comes to the foreground--waking up
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"resuming -- restore the state of the game");

    }

// state means the values of the variable -- name of player, score, level, etc
    @Override //activity goes into the background -- about to sleep
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"pausing -- save the state of the game");

    }

    @Override //activity is moved out of the ram into the hdd -- hibernate windows
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"stop");

    }

    @Override //activity doesn't exist in ram/storage
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"destroy");

    }
}