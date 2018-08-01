package com.example.ayush.firstapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.TextViewHolder> {

  List<String> dataSet = new ArrayList<>();

  OnItemClickListener itemClickListener;
  OnItemLongClickListener itemLongClickListener;


  public void setDataSet(List<String> dataSet){
    this.dataSet = dataSet;
    notifyDataSetChanged();
  }

  public void setClickListener(OnItemClickListener itemClickListener) {
    this.itemClickListener = itemClickListener;
  }

  public void setLongClickListener(OnItemLongClickListener itemLongClickListener) {
    this.itemLongClickListener = itemLongClickListener;
  }

  static class TextViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.list_item_text) TextView textView;

    TextViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

  @NonNull
  @Override
  public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    TextViewHolder holder = new TextViewHolder(inflater
        .inflate(R.layout.item_list, parent, false));
    return holder;
  }

  @Override
  public void onBindViewHolder(@NonNull final TextViewHolder holder, int position) {
    final String item = dataSet.get(position);
    holder.textView.setText(item);

    if (itemClickListener != null) {
      holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          itemClickListener.onItemClick(item, holder.getLayoutPosition());
        }
      });
    }

    if (itemLongClickListener != null) {

      holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

        @Override
        public boolean onLongClick(View view) {
          itemLongClickListener.onItemLongClick(item, holder.getLayoutPosition());
          return true;
        }
      });
    }
  }

  @Override
  public int getItemCount() {
    return dataSet.size();
  }

  public interface OnItemClickListener {
    void onItemClick(String data, int position);
  }

  public interface OnItemLongClickListener {
    void onItemLongClick(String data, int position);
  }
}
