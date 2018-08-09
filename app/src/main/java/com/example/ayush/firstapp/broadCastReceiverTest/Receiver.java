package com.example.ayush.firstapp.broadCastReceiverTest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
  @Override public void onReceive(Context context, Intent intent) {

    if(intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED")){
      Toast.makeText(context, "Power connected", Toast.LENGTH_SHORT).show();
    }
    else if(intent.getAction().equals("com.broadcast.SOME_ACTION")) {
      Toast.makeText(context, "custom broadcast received", Toast.LENGTH_SHORT).show();
    }

  }
}
