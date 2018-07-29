package com.example.ayush.firstapp.mainList;

import java.util.List;

public interface MainListContract {
  public interface View{
    void populateList(List<String> list);
  }

  public interface Presenter{
    void setMainView(View mainView);

    void getItem();
  }

}
