package com.example.ayush.firstapp;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class FragmentCommunicationActivity extends AppCompatActivity implements FragmentA.FragmentCommunicator{

  public static Intent getIntent(Context context){
    return new Intent(context, FragmentCommunicationActivity.class);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_communication);
  }

  @Override public void respond(String data) {
    FragmentManager fragmentManager = getFragmentManager();
    FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentById(R.id.fragmentB);
    fragmentB.changeText(data);
  }
}
