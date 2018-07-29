package com.example.ayush.firstapp;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainListActivity extends AppCompatActivity
    implements ListAdapter.OnItemClickListener, ListAdapter.OnItemLongClickListener {
  public static Intent getIntent(Context context) {
    return new Intent(context, MainListActivity.class);
  }

  private RecyclerView recyclerView;
  private RecyclerView.LayoutManager layoutManager;
  private ListAdapter adapter;

  List<String> items = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_list);

    recyclerView = findViewById(R.id.my_recycler);

    recyclerView.setHasFixedSize(true);

    layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    recyclerView.setLayoutManager(layoutManager);

    recyclerView.addItemDecoration(new DividerItemDecoration(this,
        DividerItemDecoration.VERTICAL));

    adapter = new ListAdapter(getItems());
    adapter.setClickListener(this);
    adapter.setLongClickListener(this);
    recyclerView.setAdapter(adapter);

    //Toolbar
    Toolbar toolbar = findViewById(R.id.app_bar);

    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    actionBar.setDisplayHomeAsUpEnabled(true);
    actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

    //drawer Fragment
    NavigationDrawerFragment drawerFragment =
        (NavigationDrawerFragment) getFragmentManager().findFragmentById(
            R.id.fragment_navigation_drawer);

    drawerFragment.setUp(R.id.fragment_navigation_drawer, findViewById(R.id.drawer_layout),
        toolbar);
  }

  public List<String> getItems() {
    items.add("Button Test");
    items.add("Image View Test");
    items.add("Relative Layout Test");
    items.add("Floating Button Test");
    items.add("Fragment test");
    items.add("Fragment Communication");
    items.add("Tabs");
    items.add("Passing Data Parcelable");
    items.add("list9");
    items.add("list10");
    items.add("list11");
    items.add("list12");
    items.add("list13");
    items.add("list14");
    items.add("list15");
    items.add("list16");
    items.add("list17");
    items.add("list18");
    items.add("list19");
    items.add("list20");

    return items;
  }

  @Override
  public void onItemClick(String data, int position) {
    switch (data) {
      case "Button Test":
        startActivity(ButtonActivity.getIntent(this));
        break;

      case "Image View Test":
        startActivity(ImageViewActivity.getIntent(this));
        break;

      case "Relative Layout Test":
        startActivity(RelativeLayoutActivity.getIntent(this));
        break;

      case "Floating Button Test":
        startActivity(FloatingActionButtonActivity.getIntent(this));
        break;

      case "Fragment test":
        startActivity(FragmentTestActivity.getIntent(this));
        break;

      case "Fragment Communication":
        startActivity(FragmentCommunicationActivity.getIntent(this));
        break;

      case "Tabs":
        startActivity(TabsActivity.getIntent(this));
        break;

      case "Passing Data Parcelable":
        startActivity(PassingDataActivity.getIntent(this));
        break;

      default:
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
  }

  @Override
  public void onItemLongClick(String data, int position) {
    //Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    Snackbar.make(findViewById(android.R.id.content), data, Snackbar.LENGTH_SHORT)
        .show();
  }

  /**
   * toolbar menu implementation
   **/
  @Override public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.settings:
        Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
