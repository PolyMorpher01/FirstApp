package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageViewActivity extends AppCompatActivity {

  public static Intent getIntent(Context context) {
    return new Intent(context, ImageViewActivity.class);
  }

  private ImageView imageView;
  private Button button;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.image_view);
    imageView = findViewById(R.id.img);
    button = findViewById(R.id.btn_image);

    imageView.setBackgroundColor(Color.BLUE);
    imageView.setTag("img1");

    button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        if (imageView.getTag().equals("img1")) {
          imageView.setImageResource(R.drawable.img_tree2);
          imageView.setTag("img2");
        } else {
          imageView.setImageResource(R.drawable.img_tree1);
          imageView.setTag("img1");
        }
      }
    });

    imageView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Toast.makeText(getBaseContext(), String.valueOf(view.getTag()), Toast.LENGTH_SHORT).show();
      }
    });
  }
}
