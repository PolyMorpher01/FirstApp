package com.example.ayush.firstapp.daggerTest;

import dagger.Module;
import dagger.Provides;

@Module
public class BravosModule {

  private Cash cash;
  private Soldiers soldiers;

  BravosModule(Cash cash, Soldiers soldiers) {
    this.cash = cash;
    this.soldiers = soldiers;
  }

  //Provides cash dependency
  @Provides Cash provideCash() {
    return cash;
  }

  //Provides soldiers dependency
  @Provides Soldiers provideSoldiers() {
    return soldiers;
  }

  @Provides Boltons provideBoltons() {
    return new Boltons();
  }

  @Provides Starks provideStarks() {
    return new Starks();
  }
}
