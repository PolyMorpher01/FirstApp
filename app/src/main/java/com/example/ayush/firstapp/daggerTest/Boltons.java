package com.example.ayush.firstapp.daggerTest;

import javax.inject.Inject;
import timber.log.Timber;

public class Boltons implements House {

  Boltons() {
  }

  @Override public void prepareForWar() {
    Timber.e(this.getClass().getSimpleName() + " prepared for war");
  }

  @Override public void reportForWar() {
    Timber.e(this.getClass().getSimpleName() + " reporting...");
  }
}
