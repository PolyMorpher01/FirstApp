package com.example.ayush.firstapp.broadCastReceiverTest;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.ayush.firstapp.R;

public class BroadcastReceiverTest extends AppCompatActivity {

  Receiver receiver;
  IntentFilter intentFilter;

  public static Intent getIntent(Context context) {
    return new Intent(context, BroadcastReceiverTest.class);
  }

  @OnClick(R.id.btn_sendBroadcast) void broadcast() {
    Intent intent = new Intent("com.broadcast.SOME_ACTION");
    sendBroadcast(intent);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.broadcast_receiver);

    ButterKnife.bind(this);

    receiver = new Receiver();

    intentFilter = new IntentFilter("com.broadcast.SOME_ACTION");
  }

  @Override protected void onResume() {
    super.onResume();
    registerReceiver(receiver, intentFilter);
  }


  @Override protected void onStop() {
    super.onStop();
    unregisterReceiver(receiver);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    //unregisterReceiver(receiver);
  }
}
