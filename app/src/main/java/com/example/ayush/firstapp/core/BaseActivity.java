package com.example.ayush.firstapp.core;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.example.ayush.firstapp.R;
import com.example.ayush.firstapp.utils.Navigator;

public abstract class BaseActivity extends AppCompatActivity {
  public Navigator navigator = new Navigator();
  private Toolbar toolbar;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(getContextView());

    if (getToolbarResource() != -1) {
      initToolbar(getToolbarResource());
    }
    if (savedInstanceState == null) {
      initializeActivity();
    }
  }

  protected abstract void initializeActivity();

  @LayoutRes
  protected abstract int getContextView();

  private void initToolbar(@IdRes int toolbarId) {
    toolbar = findViewById(toolbarId);

    setSupportActionBar(toolbar);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
    }
  }

  @NonNull
  public Toolbar getToolbar() {
    if (toolbar == null) {
      throw new RuntimeException("Override getToolbarResource() with the toolbar id");
    }
    return toolbar;
  }

  @IdRes
  protected int getToolbarResource() {
    return -1;
  }
}
