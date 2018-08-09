package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.ButterKnife;
import java.util.Arrays;
import java.util.List;

public class SwipeLayoutTestActivity extends AppCompatActivity {

  private RecyclerView recyclerView;
  private SwipeLayoutListAdapter adapter;

  public static Intent getIntent(Context context) {
    return new Intent(context, SwipeLayoutTestActivity.class);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.recycler_swipe);

    ButterKnife.bind(this);

    initRecycler();
    initAdapter();
  }

  private void initAdapter() {
    List<String> items = Arrays.asList(getResources().getStringArray(R.array.list_main));

    adapter = new SwipeLayoutListAdapter(this);
    adapter.setDataSet(items);
    recyclerView.setAdapter(adapter);

  }

  private void initRecycler() {
    recyclerView = findViewById(R.id.swipe_recycler);

    //recyclerView.setHasFixedSize(true);

    RecyclerView.LayoutManager layoutManager =
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    recyclerView.setLayoutManager(layoutManager);

    recyclerView.addItemDecoration(new DividerItemDecoration(this,
        DividerItemDecoration.VERTICAL));
  }
}
