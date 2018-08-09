package com.example.ayush.firstapp.recyclerStateTest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.ayush.firstapp.R;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;

public class RecyclerStateTestAdapter
    extends RecyclerView.Adapter<RecyclerStateTestAdapter.TextViewHolder> {
  private List<RecyclerStateTestActivity.Model> dataSet = new ArrayList<>();

  private PublishSubject<String> publishSubject = PublishSubject.create();

  public void setDataSet(List<RecyclerStateTestActivity.Model> dataSet) {
    this.dataSet = dataSet;
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public RecyclerStateTestAdapter.TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
      int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    RecyclerStateTestAdapter.TextViewHolder holder =
        new RecyclerStateTestAdapter.TextViewHolder(inflater
            .inflate(R.layout.list_checkbox, parent, false));
    return holder;
  }

  @Override
  public void onBindViewHolder(@NonNull final RecyclerStateTestAdapter.TextViewHolder holder,
      int position) {
    RecyclerStateTestActivity.Model model = dataSet.get(position);

    holder.checkBox.setText(model.getItem());
    holder.checkBox.setChecked(model.getSelected());

    holder.itemView.setOnClickListener(view -> {
          if (model.getSelected()) {
            model.setSelected(false);
          } else {
            model.setSelected(true);
          }
          publishSubject.onNext(model.getItem());
        }
    );
  }

  public Observable<String> getPublishSubject() {
    return publishSubject.filter(s -> s.contains("b"));
  }

  @Override
  public int getItemCount() {
    return dataSet.size();
  }

  static class TextViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.list_item_checkbox) CheckBox checkBox;

    TextViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
