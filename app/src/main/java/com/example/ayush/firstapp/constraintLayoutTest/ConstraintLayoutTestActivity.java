package com.example.ayush.firstapp.constraintLayoutTest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.example.ayush.firstapp.R;

public class ConstraintLayoutTestActivity extends AppCompatActivity {

  public static Intent getIntent(Context context) {
    return new Intent(context, ConstraintLayoutTestActivity.class);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.constraint_layout_test);

    ButterKnife.bind(this);
  }
}
