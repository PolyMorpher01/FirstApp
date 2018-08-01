package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import com.example.ayush.firstapp.utils.Navigator;
import timber.log.Timber;

public class LogTestActivity extends AppCompatActivity {

  public static Intent getIntent(Context context) {
    return new Intent(context, LogTestActivity.class);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.buttons);

    Button button = findViewById(R.id.button1);
    //button.setText("hello");

    button.setOnClickListener(view -> {
      //Timber.tag("tag1").d("new Message");
      Timber.d("debug Message");
      Timber.e("Error Message");
      Timber.w("warning Message");
      Timber.v("Verbose Message");

    });
  }
}
