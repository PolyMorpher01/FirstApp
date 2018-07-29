package com.example.ayush.firstapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class FragmentTestActivity extends AppCompatActivity {
  public static Intent getIntent(Context context){
    return new Intent(context, FragmentTestActivity.class);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_test);

    MyFragment fragment = new MyFragment();

    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();

    transaction.add(R.id.fragment_test,fragment,"myFragment");
    transaction.commit();

    Button button = findViewById(R.id.btn_show);
    button.setOnClickListener(view -> showDialog());
  }

  void showDialog(){
    FragmentManager fragmentManager = getFragmentManager();
    DialogFragment dialogFragment = new DialogFragment();
    dialogFragment.show(fragmentManager, "My Dialog");
  }
}
