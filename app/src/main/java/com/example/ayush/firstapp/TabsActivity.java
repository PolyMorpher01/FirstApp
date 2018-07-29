package com.example.ayush.firstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class TabsActivity extends FragmentActivity {

  public static Intent getIntent(Context context) {
    return new Intent(context, TabsActivity.class);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tabs);

    TabLayout tabLayout = findViewById(R.id.tab_layout);
    ViewPager viewPager = findViewById(R.id.view_pager);

    MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

    viewPager.setAdapter(myPagerAdapter);

    //deprecated and not needed anymore
    //tabLayout.setTabsFromPagerAdapter(myPagerAdapter);

    tabLayout.setupWithViewPager(viewPager);
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
  }
}

class MyPagerAdapter extends FragmentPagerAdapter {

  public MyPagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override public Fragment getItem(int position) {
    Fragment fragment = null;
    if (position == 0) {
      fragment = new Fragment1();
    } else if (position == 1) {
      fragment = new Fragment2();
    } else if (position == 2) {
      fragment = new Fragment3();
    }
    return fragment;
  }

  @Override public int getCount() {
    return 3;
  }

  @Nullable @Override public CharSequence getPageTitle(int position) {
    return "Tab " + (position + 1);
  }
}