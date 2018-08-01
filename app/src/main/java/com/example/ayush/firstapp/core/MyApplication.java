package com.example.ayush.firstapp.core;

import android.app.Application;
import com.example.ayush.firstapp.BuildConfig;
import com.example.ayush.firstapp.timber.DebugLogTree;
import com.example.ayush.firstapp.timber.ReleaseLogTree;
import com.squareup.leakcanary.LeakCanary;
import timber.log.Timber;

public class MyApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();

    if (LeakCanary.isInAnalyzerProcess(this)) {
      return;
    }
    LeakCanary.install(this);

    if (BuildConfig.DEBUG) {
      Timber.plant(new DebugLogTree());
    } else {
      Timber.plant(new ReleaseLogTree());
    }
  }
}
