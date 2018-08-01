package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.ayush.firstapp.utils.Navigator;

public class SharedPreferencesActivity extends AppCompatActivity {

  public static Intent getIntent(Context context){
    return new Intent(context, SharedPreferencesActivity.class);
  }

  EditText uname, password;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.shared_pref);

    Button next = findViewById(R.id.btn_prev);
    Button save = findViewById(R.id.btn_load);
    uname = findViewById(R.id.uname);
    password = findViewById(R.id.password);

    Navigator navigator = new Navigator();

    next.setOnClickListener(view-> navigator.navigateSharedPreferences2Activity(this));
    save.setOnClickListener(view->saveData());
  }

  public void saveData(){
    SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor =  sharedPreferences.edit();

    editor.putString("name",uname.getText().toString());
    editor.putString("password",password.getText().toString());
    editor.apply();
  }
}
