package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class PassingData2Activity extends AppCompatActivity {

  private static final String ARGS_NAME = "name";
  private static final String ARGS_AGE = "age";
  private static final String ARGS_STUDENT = "student";

  public static Intent getIntent(Context context, String name, int age,
      ParcelableDemo parcelableDemo) {
    Intent intent = new Intent(context, PassingData2Activity.class);
    intent.putExtra(ARGS_NAME, name);
    intent.putExtra(ARGS_AGE, age);
    intent.putExtra(ARGS_STUDENT, parcelableDemo);
    return intent;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.passing_data_2);

    TextView textView = findViewById(R.id.text1);

    Intent intent = getIntent();
    Bundle extras = intent.getExtras();
    String name = getName();
    int age = intent.getIntExtra(ARGS_AGE, 0);

    ParcelableDemo student = intent.getParcelableExtra(ARGS_STUDENT);
    Log.d("hello", "onCreate: "+student);

    textView.setText("Name: " + student.mSName + "\nAge: " + student.mSAge + "\nAddress: "
        + student.mSAddress + "\nCourse: " + student.mSCourse);
  }


  public String getName(){
    if(getIntent()!=null && getIntent().hasExtra(ARGS_NAME)){
      return getIntent().getStringExtra(ARGS_NAME);
    }
    return "";
  }
}
