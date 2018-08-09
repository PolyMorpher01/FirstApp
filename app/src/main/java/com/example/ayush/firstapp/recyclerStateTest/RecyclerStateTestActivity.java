package com.example.ayush.firstapp.recyclerStateTest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.example.ayush.firstapp.R;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerStateTestActivity extends AppCompatActivity {

  private RecyclerView recyclerView;
  private RecyclerStateTestAdapter adapter;
  private Disposable subscribe;

  public static Intent getIntent(Context context) {
    return new Intent(context, RecyclerStateTestActivity.class);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_list);

    initRecycler();
    initAdapter();
  }

  private void initAdapter() {
    List<String> items = Arrays.asList(getResources().getStringArray(R.array.list_main));

    List<Model> modelList = new ArrayList<>();

    for (String item : items) {
      Model model = new Model();
      model.setItem(item);
      model.setSelected(false);
      modelList.add(model);
    }

    adapter = new RecyclerStateTestAdapter();
    subscribe = adapter.getPublishSubject()
        .doOnNext(data -> Toast.makeText(RecyclerStateTestActivity.this, "You Clicked " + data,
            Toast.LENGTH_SHORT).show())
        .doOnError(Throwable::printStackTrace)
        .doOnComplete(() -> {
        })
        .subscribe();

    recyclerView.setAdapter(adapter);
    adapter.setDataSet(modelList);
  }

  private void initRecycler() {
    recyclerView = findViewById(R.id.my_recycler);

    recyclerView.setHasFixedSize(true);

    RecyclerView.LayoutManager layoutManager =
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    recyclerView.setLayoutManager(layoutManager);

    recyclerView.addItemDecoration(new DividerItemDecoration(this,
        DividerItemDecoration.VERTICAL));
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    if (subscribe != null && !subscribe.isDisposed()) {
      subscribe.dispose();
    }
  }

  class Model {
    public String item;
    public boolean isSelected;

    public String getItem() {
      return item;
    }

    public void setItem(String item) {
      this.item = item;
    }

    public boolean getSelected() {
      return isSelected;
    }

    public void setSelected(boolean selected) {
      isSelected = selected;
    }
  }
}
