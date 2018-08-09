package com.example.ayush.firstapp.daggerTest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.example.ayush.firstapp.R;
import javax.inject.Inject;

public class DaggerTestActivity extends AppCompatActivity {

  @Inject
  War war;

  public static Intent getIntent(Context context) {
    return new Intent(context, DaggerTestActivity.class);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.dagger_test);

    ButterKnife.bind(this);

    //Manual DI
   /* Boltons boltons = new Boltons();
    Starks starks = new Starks();

    War war = new War(boltons, starks);

    war.prepare();
    war.report();*/

    //Using Dagger2

    Cash cash = new Cash();
    Soldiers soldiers = new Soldiers();

    /*
    BattleComponent battleComponent = DaggerDaggerTestActivity_BattleComponent.builder()
        .bravosModule(new BravosModule(cash, soldiers))
        .build();
    */

    DaggerBattleComponent.builder()
        .bravosModule(new BravosModule(cash, soldiers))
        .build().inject(this);

    //War war = battleComponent.getWar();
    war.prepare();
    war.report();

    //using cash soldiers
    //battleComponent.getCash();
    //battleComponent.getSoldiers();
  }
}
