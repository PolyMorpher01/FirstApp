package com.example.ayush.firstapp.retroFitTest.pojo;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UserList {

  @SerializedName("page") public int page;
  @SerializedName("per_page") public int perPage;
  @SerializedName("total") public int total;
  @SerializedName("total_pages") public int totalPages;
  @SerializedName("data") public List<Datum> data = null;

  public static class Datum {

    @SerializedName("id") public int id;
    @SerializedName("first_name") public String firstName;
    @SerializedName("last_name") public String lastName;
    @SerializedName("avatar") public String avatar;
  }
}
