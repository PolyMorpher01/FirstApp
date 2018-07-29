package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class NavigationDrawerActivity extends AppCompatActivity {
  public static Intent getIntent(Context context){
    return new Intent(context, NavigationDrawerActivity.class);
  }
}
