package com.example.ayush.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.example.ayush.firstapp.mainList.MainListActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent mainListIntent = MainListActivity.getIntent(this);
        startActivity(mainListIntent);
    }
}
