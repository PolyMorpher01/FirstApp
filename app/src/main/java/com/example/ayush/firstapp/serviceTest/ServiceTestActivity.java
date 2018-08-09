package com.example.ayush.firstapp.serviceTest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.ayush.firstapp.R;

public class ServiceTestActivity extends AppCompatActivity {

  public static Intent getIntent(Context context){
    return new Intent(context, ServiceTestActivity.class);
  }


  @OnClick(R.id.btn_start) void start(){
    startService(new Intent(this, MyService.class));
  }

  @OnClick(R.id.btn_stop) void stop(){
    stopService(new Intent(this, MyService.class));
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.service_test);

    ButterKnife.bind(this);

  }
}
