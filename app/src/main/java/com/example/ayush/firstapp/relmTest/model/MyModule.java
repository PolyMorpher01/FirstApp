package com.example.ayush.firstapp.relmTest.model;

import io.realm.annotations.RealmModule;

@RealmModule(classes = {Todo.class, User.class})
public class MyModule {
}
