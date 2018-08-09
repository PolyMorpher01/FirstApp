package com.example.ayush.firstapp.customViews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.example.ayush.firstapp.R;

public class CompoundViewActivity extends AppCompatActivity{

  public static Intent getIntent(Context context) {
    return new Intent(context, CompoundViewActivity.class);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.compound_view_test);

    ButterKnife.bind(this);

  }
}
