package com.example.ayush.firstapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

public class SwipeLayoutListAdapter
    extends RecyclerSwipeAdapter<SwipeLayoutListAdapter.ViewHolder> {

  private Context context;
  private List<String> dataSet = new ArrayList<>();

  SwipeLayoutListAdapter(Context context) {
    this.context = context;
  }

  public void setDataSet(List<String> dataSet) {
    this.dataSet = dataSet;
    notifyDataSetChanged();
  }

  @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    ViewHolder holder = new ViewHolder(inflater
        .inflate(R.layout.swipe_layout, parent, false));
    return holder;
  }

  @Override public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
    final String item = dataSet.get(position);
    viewHolder.textView.setText(item);

    //set show mode.
    viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);

    //drag from left
    viewHolder.swipeLayout.addDrag(SwipeLayout.DragEdge.Left,
        viewHolder.swipeLayout.findViewById(R.id.bottom_wrapper));

    viewHolder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
      @Override
      public void onClose(SwipeLayout layout) {
        //when the SurfaceView totally cover the BottomView.
        Timber.i("on close");
      }

      @Override
      public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
        //you are swiping.
        Timber.i("on swiping");
      }

      @Override
      public void onStartOpen(SwipeLayout layout) {
        Timber.i("on start open");
      }

      @Override
      public void onOpen(SwipeLayout layout) {
        //when the BottomView totally show.
        Timber.i("Bottom view totally show");
      }

      @Override
      public void onStartClose(SwipeLayout layout) {
        Timber.i("bottom view totally close");
      }

      @Override
      public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
        //when user's hand released.
      }
    });
  }

  @Override public int getItemCount() {
    return dataSet.size();
  }

  @Override public int getSwipeLayoutResourceId(int position) {
    return R.id.swipe_layout;
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.swipe_layout) SwipeLayout swipeLayout;
    @BindView(R.id.list_item_swipe) TextView textView;

    ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
