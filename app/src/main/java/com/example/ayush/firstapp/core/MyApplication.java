package com.example.ayush.firstapp.core;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import com.example.ayush.firstapp.BuildConfig;
import com.example.ayush.firstapp.relmTest.model.MyModule;
import com.example.ayush.firstapp.timber.DebugLogTree;
import com.example.ayush.firstapp.timber.ReleaseLogTree;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

public class MyApplication extends MultiDexApplication {
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

    //realm
    Realm.init(this);

    RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
        .name("todo.realm")
        .schemaVersion(0)
        .modules(new MyModule())
        .build();

    Realm.setDefaultConfiguration(realmConfiguration);

    Stetho.initialize(
        Stetho.newInitializerBuilder(this)
            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
            .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
            .build());
  }

  @Override protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
  }
}
