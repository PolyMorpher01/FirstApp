package com.example.ayush.firstapp.daggerTest;

import javax.inject.Inject;

public class War {

  @Inject Boltons boltons;
  @Inject Starks starks;

  @Inject War(Boltons boltons, Starks starks) {
    this.boltons = boltons;
    this.starks = starks;
  }

  public void prepare() {
    boltons.prepareForWar();
    starks.prepareForWar();
  }

  public void report() {
    boltons.reportForWar();
    starks.reportForWar();
  }
}
