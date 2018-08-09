package com.example.ayush.firstapp.relmTest.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Todo extends RealmObject{

  @PrimaryKey
  private String id;

  private String task;
  private boolean isCompleted;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public boolean isCompleted() {
    return isCompleted;
  }

  public void setCompleted(boolean completed) {
    isCompleted = completed;
  }

  public Todo() {
  }

}
