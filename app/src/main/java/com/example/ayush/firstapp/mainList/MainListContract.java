package com.example.ayush.firstapp.mainList;

import java.util.List;

public interface MainListContract {
  interface View{
    void populateList(List<String> list);
  }

  interface Presenter{
    void setMainView(View mainView);
    void getItem();
  }

}
