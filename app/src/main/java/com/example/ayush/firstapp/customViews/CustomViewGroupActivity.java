package com.example.ayush.firstapp.customViews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class CustomViewGroupActivity extends AppCompatActivity {

  public static Intent getIntent(Context context) {
    return new Intent(context, CustomViewGroupActivity.class);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
}
