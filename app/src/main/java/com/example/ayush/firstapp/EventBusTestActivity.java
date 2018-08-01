package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import org.greenrobot.eventbus.EventBus;

public class EventBusTestActivity extends AppCompatActivity {

  @BindView(R.id.btn_next) Button button;
  @BindView(R.id.txt1) TextView textView;

  public static Intent getIntent(Context context) {
    return new Intent(context, EventBusTestActivity.class);
  }

  @OnClick(R.id.btn_next) void prev() {
    String message = textView.getText().toString();

    EventBus.getDefault().post(new EventMessage(message));
    finish();
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.event_bus);
    ButterKnife.bind(this);
  }
}
