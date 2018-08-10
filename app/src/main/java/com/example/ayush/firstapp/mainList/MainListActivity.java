package com.example.ayush.firstapp.mainList;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.example.ayush.firstapp.ListAdapter;
import com.example.ayush.firstapp.NavigationDrawerFragment;
import com.example.ayush.firstapp.R;
import com.example.ayush.firstapp.broadCastReceiverTest.BroadcastReceiverTest;
import com.example.ayush.firstapp.constraintLayoutTest.ConstraintLayoutTestActivity;
import com.example.ayush.firstapp.core.BaseActivity;
import com.example.ayush.firstapp.customViews.CompoundViewActivity;
import com.example.ayush.firstapp.customViews.CustomViewActivity;
import com.example.ayush.firstapp.customViews.CustomViewGroupActivity;
import com.example.ayush.firstapp.daggerTest.DaggerTestActivity;
import com.example.ayush.firstapp.httpUrlConnectionTest.HttpTestActivity;
import com.example.ayush.firstapp.locationTest.LocationTestActivity;
//import com.example.ayush.firstapp.locationTest.MapsActivity;
import com.example.ayush.firstapp.recyclerStateTest.RecyclerStateTestActivity;
import com.example.ayush.firstapp.relmTest.model.RealmTestActivity;
import com.example.ayush.firstapp.retroFitTest.RetroFitTestActivity;
import com.example.ayush.firstapp.rxTest.RxTest;
import com.example.ayush.firstapp.serviceTest.ServiceTestActivity;
import java.util.List;

public class MainListActivity extends BaseActivity
    implements ListAdapter.OnItemClickListener, ListAdapter.OnItemLongClickListener,
    MainListContract.View {

  private RecyclerView recyclerView;
  private ListAdapter adapter;

  public static Intent getIntent(Context context) {
    return new Intent(context, MainListActivity.class);
  }

  @Override protected int getContextView() {
    return R.layout.main_list;
  }

  @Override protected int getToolbarResource() {
    return R.id.app_bar;
  }

  @Override protected void initializeActivity() {
    initRecycler();
    initAdapter();

    MainListContract.Presenter presenter = new MainListPresenter(this);
    presenter.setMainView(this);
    presenter.getItem();

    drawerFragment();
  }

  private void initAdapter() {
    adapter = new ListAdapter();
    adapter.setClickListener(this);
    adapter.setLongClickListener(this);
    recyclerView.setAdapter(adapter);
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

  private void drawerFragment() {
    NavigationDrawerFragment drawerFragment =
        (NavigationDrawerFragment) getFragmentManager().findFragmentById(
            R.id.fragment_navigation_drawer);

    drawerFragment.setUp(R.id.fragment_navigation_drawer, findViewById(R.id.drawer_layout),
        getToolbar());
  }

  @Override public void populateList(List<String> list) {
    adapter.setDataSet(list);
  }

  @Override
  public void onItemClick(String data, int position) {
    switch (data) {
      case "Button Test":
        navigator.navigateButtonActivity(this);
        break;

      case "Image View Test":
        navigator.navigateImageActivity(this);
        break;

      case "Relative Layout Test":
        navigator.navigateRelativeLayoutActivity(this);
        break;

      case "Floating Button Test":
        navigator.navigateFloatingActionButtonActivity(this);
        break;

      case "Fragment Test":
        navigator.navigateFragmentTestActivity(this);
        break;

      case "Fragment Communication":
        navigator.navigateFragmentCommunicationActivity(this);
        break;

      case "Tabs":
        navigator.navigateTabsActivity(this);
        break;

      case "Passing Data Parcelable":
        navigator.navigatePassingDataActivity(this);
        break;

      case "Log Test":
        navigator.navigateLogTestActivity(this);
        break;

      case "Shared Preferences":
        navigator.navigateSharedPreferencesActivity(this);
        break;

      case "Swipe Layout Test":
        navigator.navigateSwipeLayoutTestActivity(this);
        break;

      case "Event Bus Test":
        navigator.navigateEventBus2Activity(this);
        break;

      case "Http Test":
        startActivity(HttpTestActivity.getIntent(this));
        break;

      case "RetroFit Test":
        startActivity(RetroFitTestActivity.getIntent(this));
        break;

      case "Service Test":
        startActivity(ServiceTestActivity.getIntent(this));
        break;

      case "BroadCastReceiver Test":
        startActivity(BroadcastReceiverTest.getIntent(this));
        break;

      case "Recycler state test":
        startActivity(RecyclerStateTestActivity.getIntent(this));
        break;

      case "Realm Test":
        startActivity(RealmTestActivity.getIntent(this));
        break;

      case "Rx Test":
        startActivity(RxTest.getIntent(this));
        break;

      case "Custom View Test":
        startActivity(CustomViewActivity.getIntent(this));
        break;

      case "Compound View Test":
        startActivity(CompoundViewActivity.getIntent(this));
        break;

      case "Custom View group":
        startActivity(CustomViewGroupActivity.getIntent(this));
        break;

      case "Dagger Test":
        startActivity(DaggerTestActivity.getIntent(this));
        break;

      case "Constraint Layout Test":
        startActivity(ConstraintLayoutTestActivity.getIntent(this));
        break;

      case "Crash Test":
        Crashlytics.log(1,"crash","here comes the crash");
        Crashlytics.getInstance().crash();
        break;

      case "Map Test":
        startActivity(LocationTestActivity.getIntent(this));
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
