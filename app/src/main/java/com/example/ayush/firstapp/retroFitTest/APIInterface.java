package com.example.ayush.firstapp.retroFitTest;

import com.example.ayush.firstapp.retroFitTest.pojo.SingleUser;
import com.example.ayush.firstapp.retroFitTest.pojo.User;
import com.example.ayush.firstapp.retroFitTest.pojo.UserList;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

  @GET("/api/users?")
  Call<UserList> getUsersList(@Query("page") String page);

  @GET("/api/users/{id}")
  Call<SingleUser> getById(@Path("id") int id);

  @POST("/api/users")
  Call<User> create(@Body User user);
}
