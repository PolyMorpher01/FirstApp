package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class PassingData2Activity extends AppCompatActivity {

  public static Intent getIntent(Context context) {
    Intent intent = new Intent(context, PassingData2Activity.class);
    return intent;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.passing_data_2);

    TextView textView = findViewById(R.id.text1);

    Intent intent = getIntent();
    Bundle extras = intent.getExtras();
    String name = extras.getString("name");
    String age = intent.getStringExtra("age");

    ParcelableDemo student = intent.getParcelableExtra("student");
    Log.d("hello", "onCreate: "+student);

    textView.setText("Name: " + student.mSName + "\nAge: " + student.mSAge + "\nAddress: "
        + student.mSAddress + "\nCourse: " + student.mSCourse);
  }
}
