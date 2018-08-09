package com.example.ayush.firstapp.customViews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.ayush.firstapp.R;

public class CustomViewActivity extends AppCompatActivity {

  @BindView(R.id.custom)
  CustomView customView;

  public static Intent getIntent(Context context) {
    return new Intent(context, CustomViewActivity.class);
  }

  @OnClick(R.id.btn_swap) void swapColor() {
    customView.swapColor();
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.custom_view);

    ButterKnife.bind(this);
  }
}
