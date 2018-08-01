package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import com.example.ayush.firstapp.utils.Navigator;

public class SharedPreferences2Activity extends AppCompatActivity {

  public static Intent getIntent(Context context){
    return new Intent(context, SharedPreferences2Activity.class);
  }


  EditText uname, password;


  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.shared_pref_2);

    Button prev = findViewById(R.id.btn_prev);
    Button load = findViewById(R.id.btn_load);
    uname = findViewById(R.id.uname);
    password = findViewById(R.id.password);

    Navigator navigator = new Navigator();

    prev.setOnClickListener(view-> navigator.navigateSharedPreferencesActivity(this));
    load.setOnClickListener(view->loadData());
  }

  public void loadData(){
    SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);

    String name = sharedPreferences.getString("name","");
    String pass = sharedPreferences.getString("password","");

    uname.setText(name);
    password.setText(pass);

  }

}
