package com.example.ayush.firstapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;


public class NavigationDrawerFragment extends Fragment {

  static final String PREF_FILE_NAME = "testPref";
  static final String KEY_USER_LEARNED_DRAWABLE = "key_user_learned_drawable";

  ActionBarDrawerToggle drawerToggle;
  DrawerLayout drawerLayout;

  boolean mUserLearnedDrawer; //to check if user has opened drawer
  boolean mFromSavedInstanceState; //to check state when orientation changes

  public NavigationDrawerFragment() {
    // Required empty public constructor
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mUserLearnedDrawer =
        Boolean.parseBoolean(
            readFramPreferences(getActivity(), KEY_USER_LEARNED_DRAWABLE, "false"));

    if (savedInstanceState != null) {
      mFromSavedInstanceState = true;
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
  }

  View containerView;

  public void setUp(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {

    containerView = getView().findViewById(fragmentId);

    this.drawerLayout = drawerLayout;
    drawerToggle =
        new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open,
            R.string.drawer_close) {

          @Override public void onDrawerOpened(View drawerView) {
            super.onDrawerOpened(drawerView);

            if (!mUserLearnedDrawer) {
              mUserLearnedDrawer = true;
              saveToPreferences(getActivity(), KEY_USER_LEARNED_DRAWABLE,
                  String.valueOf(mUserLearnedDrawer));
            }

            getActivity().invalidateOptionsMenu();
          }

          @Override public void onDrawerClosed(View drawerView) {
            super.onDrawerClosed(drawerView);

            getActivity().invalidateOptionsMenu();
          }

          //for slide fade effect
       /*   @Override public void onDrawerSlide(View drawerView, float slideOffset) {
            if(slideOffset<0.6){
              toolbar.setAlpha(1-slideOffset);
            }
          }*/
        };

    if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
      drawerLayout.openDrawer(containerView);
    }

    drawerLayout.addDrawerListener(drawerToggle);
    drawerLayout.post(() -> drawerToggle.syncState());
  }

  static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
    SharedPreferences sharedPreferences =
        context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString(preferenceName, preferenceValue);
    editor.apply();
  }

  static String readFramPreferences(Context context, String preferenceName, String defaultValue) {
    SharedPreferences sharedPreferences =
        context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

    return sharedPreferences.getString(preferenceName, defaultValue);
  }
}
