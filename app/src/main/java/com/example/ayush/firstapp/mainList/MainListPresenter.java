package com.example.ayush.firstapp.mainList;

import android.content.Context;
import com.example.ayush.firstapp.R;
import java.util.Arrays;
import java.util.List;

public class MainListPresenter implements MainListContract.Presenter {

  final Context context;
  MainListContract.View mainView;

  @Override public void setMainView(MainListContract.View mainView) {
    this.mainView = mainView;
  }


  public MainListPresenter(Context context) {
    this.context = context;
  }

  @Override public void getItem(){
    List<String> items = Arrays.asList(context.getResources().getStringArray(R.array.list_main));
    mainView.populateList(items);
  }
}
