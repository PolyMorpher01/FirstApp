package com.example.ayush.firstapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentA extends Fragment {

  int counter = 0;

  FragmentCommunicator fragmentCommunicator;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_a, container, false);
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    fragmentCommunicator = (FragmentCommunicator) getActivity();//??

    Button button = getActivity().findViewById(R.id.button1);

    button.setOnClickListener(view -> {
      counter++;
      fragmentCommunicator.respond("The Button Was clicked " + counter + " times.");
    });
  }

  public interface FragmentCommunicator {
    void respond(String data);
  }
}
