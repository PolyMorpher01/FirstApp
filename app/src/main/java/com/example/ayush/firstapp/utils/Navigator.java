package com.example.ayush.firstapp.utils;

import android.content.Context;
import com.example.ayush.firstapp.ButtonActivity;
import com.example.ayush.firstapp.EventBusTestActivity;
import com.example.ayush.firstapp.EventBusTest2Activity;
import com.example.ayush.firstapp.FloatingActionButtonActivity;
import com.example.ayush.firstapp.FragmentCommunicationActivity;
import com.example.ayush.firstapp.FragmentTestActivity;
import com.example.ayush.firstapp.ImageViewActivity;
import com.example.ayush.firstapp.LogTestActivity;
import com.example.ayush.firstapp.PassingDataActivity;
import com.example.ayush.firstapp.RelativeLayoutActivity;
import com.example.ayush.firstapp.SharedPreferences2Activity;
import com.example.ayush.firstapp.SharedPreferencesActivity;
import com.example.ayush.firstapp.SwipeLayoutTestActivity;
import com.example.ayush.firstapp.TabsActivity;

public class Navigator {

  public void navigateButtonActivity(Context context) {
    context.startActivity(ButtonActivity.getIntent(context));
  }

  public void navigateImageActivity(Context context) {
    context.startActivity(ImageViewActivity.getIntent(context));
  }

  public void navigateRelativeLayoutActivity(Context context) {
    context.startActivity(RelativeLayoutActivity.getIntent(context));
  }

  public void navigateFloatingActionButtonActivity(Context context) {
    context.startActivity(FloatingActionButtonActivity.getIntent(context));
  }

  public void navigateFragmentTestActivity(Context context) {
    context.startActivity(FragmentTestActivity.getIntent(context));
  }

  public void navigateFragmentCommunicationActivity(Context context) {
    context.startActivity(FragmentCommunicationActivity.getIntent(context));
  }

  public void navigateTabsActivity(Context context) {
    context.startActivity(TabsActivity.getIntent(context));
  }

  public void navigatePassingDataActivity(Context context) {
    context.startActivity(PassingDataActivity.getIntent(context));
  }

  public void navigateLogTestActivity(Context context) {
    context.startActivity(LogTestActivity.getIntent(context));
  }

  public void navigateSharedPreferencesActivity(Context context) {
    context.startActivity(SharedPreferencesActivity.getIntent(context));
  }

  public void navigateSharedPreferences2Activity(Context context) {
    context.startActivity(SharedPreferences2Activity.getIntent(context));
  }

  public void navigateSwipeLayoutTestActivity(Context context) {
    context.startActivity(SwipeLayoutTestActivity.getIntent(context));
  }

  public void navigateEventBusActivity(Context context) {
    context.startActivity(EventBusTestActivity.getIntent(context));
  }

  public void navigateEventBus2Activity(Context context) {
    context.startActivity(EventBusTest2Activity.getIntent(context));
  }
}
