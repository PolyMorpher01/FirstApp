package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButtonActivity extends AppCompatActivity {

  @BindView(R.id.button1) Button button1;

  public static Intent getIntent(Context context) {
    return new Intent(context, ButtonActivity.class);
  }

  @OnClick(R.id.button1) void showMessage() {
    Toast.makeText(ButtonActivity.this,
        "You clicked a button", Toast.LENGTH_SHORT)
        .show();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.buttons);

    ButterKnife.bind(this);

    //Toolbar
    Toolbar toolbar = findViewById(R.id.app_bar);
    setSupportActionBar(toolbar);

    //enable home button in toolbar
    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  /**
   * toolbar menu implementation
   **/
  @Override public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.settings:
        Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
        return true;

      case android.R.id.home:
        NavUtils.navigateUpFromSameTask(this);
        return true;

      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
