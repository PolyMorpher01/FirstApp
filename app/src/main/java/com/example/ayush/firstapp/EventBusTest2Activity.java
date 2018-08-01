package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusTest2Activity extends AppCompatActivity {

  public static Intent getIntent(Context context){
    return new Intent(context, EventBusTest2Activity.class);
  }

  @BindView(R.id.txt_1) TextView textView;

  @OnClick(R.id.btn_next) void next(){
    startActivity(EventBusTestActivity.getIntent(this));
    //finish();
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.event_bus2);
    ButterKnife.bind(this);

    EventBus.getDefault().register(this);
  }

  @Override protected void onResume() {
    super.onResume();
    textView.requestLayout();
  }


  @Override protected void onDestroy() {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
  }

  @Subscribe(threadMode = ThreadMode.MAIN)
  public void onEventMessage(EventMessage event){

    textView.setText(event.mMessage);
    Toast.makeText(this, event.mMessage, Toast.LENGTH_SHORT).show();
  }

}
