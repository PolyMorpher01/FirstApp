package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RelativeLayoutActivity extends AppCompatActivity {

  public static Intent getIntent(Context context) {
    return new Intent(context, RelativeLayoutActivity.class);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.relative_layout_test);

    final EditText txt_password = findViewById(R.id.txt_password);
    final Button btn_showPassword = findViewById(R.id.btn_showPassword);

    btn_showPassword.setOnClickListener((view) -> {
      if (btn_showPassword.getText().equals("show password")) {
        txt_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        btn_showPassword.setText("hide password");
      } else {
        txt_password.setInputType(
            InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        btn_showPassword.setText("show password");
      }
    });
  }
}
