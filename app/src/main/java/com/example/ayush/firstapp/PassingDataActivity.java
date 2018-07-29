package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class PassingDataActivity extends AppCompatActivity {

  public static Intent getIntent(Context context) {
    Intent intent = new Intent(context, PassingDataActivity.class);
    return intent;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.passing_data);

    TextView btn = findViewById(R.id.btn_next);
    EditText name = findViewById(R.id.txt_Name);
    EditText age = findViewById(R.id.txt_Age);
    EditText address = findViewById(R.id.txt_address);
    EditText course = findViewById(R.id.txt_course);



    btn.setOnClickListener(view -> {

      ParcelableDemo parcelableDemo =
          new ParcelableDemo(name.getText().toString(), age.getText().toString(),
              address.getText().toString(), course.getText().toString());

      Intent intent = PassingData2Activity.getIntent(this);
      intent.putExtra("name", "joe");
      intent.putExtra("age", "26");
      intent.putExtra("student", parcelableDemo);

      startActivity(intent);
    });
  }
}
