package com.example.ayush.firstapp.retroFitTest.pojo;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SingleUser {

  @SerializedName("data") public SingleUser.Data data = null;

  public static class Data {

    @SerializedName("id") public int id;
    @SerializedName("first_name") public String firstName;
    @SerializedName("last_name") public String lastName;
    @SerializedName("avatar") public String avatar;
  }
}
