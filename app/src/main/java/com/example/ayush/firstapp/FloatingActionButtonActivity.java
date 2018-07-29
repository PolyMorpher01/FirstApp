package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class FloatingActionButtonActivity extends AppCompatActivity {

  public static Intent getIntent(Context context){
    return new Intent(context,FloatingActionButtonActivity.class );
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.floating_button_test);

    FloatingActionButton floatingActionButton = findViewById(R.id.btn_floating);

    floatingActionButton.setOnClickListener(view -> {
      Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show();
    });
  }
}
