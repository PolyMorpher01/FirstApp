package com.example.ayush.firstapp.daggerTest;

import dagger.Component;

@Component(modules = BravosModule.class) public interface BattleComponent {
  //War getWar();

  void inject(DaggerTestActivity daggerTestActivity);

  //
  //Cash getCash();
  //
  //Soldiers getSoldiers();
}
