package com.example.ayush.firstapp.daggerTest;

import javax.inject.Inject;
import timber.log.Timber;

public class Starks implements House {

  Starks() {
  }

  @Override public void prepareForWar() {
    Timber.e(this.getClass().getSimpleName() + " prepared for war");
  }

  @Override public void reportForWar() {
    Timber.e(this.getClass().getSimpleName() + " reporting...");
  }
}
