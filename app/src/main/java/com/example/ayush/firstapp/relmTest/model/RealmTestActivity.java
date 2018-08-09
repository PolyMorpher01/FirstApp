package com.example.ayush.firstapp.relmTest.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.ayush.firstapp.R;
import io.realm.Realm;
import io.realm.RealmResults;
import java.util.UUID;

public class RealmTestActivity extends AppCompatActivity {

  Realm realm;
  @BindView(R.id.txt_task) EditText textTask;
  @BindView(R.id.chk_isComplete) CheckBox chk_isComplete;
  @BindView(R.id.fetched_data) TextView fetchData;

  public static Intent getIntent(Context context) {
    return new Intent(context, RealmTestActivity.class);
  }

  @OnClick(R.id.btn_insert) void insert() {

    newTodo(textTask.getText().toString(), chk_isComplete.isChecked());
  }

  @OnClick(R.id.btn_fetch) void fetch() {
    fetchTodos();
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.realm_test);

    ButterKnife.bind(this);

    realm = Realm.getDefaultInstance();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    realm.close();
  }

  public void newTodo(String task, boolean isComplete) {
    realm.executeTransaction(realm -> {
          Todo todo = new Todo();
          todo.setId(UUID.randomUUID().toString());
          todo.setTask(task);
          todo.setCompleted(isComplete);
          realm.insert(todo);
        }
    );
  }

  public void fetchTodos() {

    realm.executeTransaction(realm -> {
          RealmResults<Todo> todos = realm.where(Todo.class).findAll();

          for (Todo todo : todos) {
            fetchData.append(todo.toString());
          }
        }

    );
  }
}
