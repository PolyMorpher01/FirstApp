package com.example.ayush.firstapp.utils;

import android.content.Context;
import com.example.ayush.firstapp.ButtonActivity;
import com.example.ayush.firstapp.FloatingActionButtonActivity;
import com.example.ayush.firstapp.FragmentCommunicationActivity;
import com.example.ayush.firstapp.FragmentTestActivity;
import com.example.ayush.firstapp.ImageViewActivity;
import com.example.ayush.firstapp.PassingDataActivity;
import com.example.ayush.firstapp.RelativeLayoutActivity;
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

}
