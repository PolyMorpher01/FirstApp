package com.example.ayush.firstapp.locationTest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class LocationTestActivity extends AppCompatActivity {

  public static Intent getIntent(Context context) {
    return new Intent(context, LocationTestActivity.class);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
}

