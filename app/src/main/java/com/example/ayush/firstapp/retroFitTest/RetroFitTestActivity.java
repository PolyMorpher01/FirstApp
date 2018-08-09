package com.example.ayush.firstapp.retroFitTest;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.ayush.firstapp.R;
import com.example.ayush.firstapp.retroFitTest.pojo.SingleUser;
import com.example.ayush.firstapp.retroFitTest.pojo.User;
import com.example.ayush.firstapp.retroFitTest.pojo.UserList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class RetroFitTestActivity extends AppCompatActivity {

  @BindView(R.id.txt_response) TextView resposneText;
  APIInterface apiInterface;

  public static Intent getIntent(Context context) {
    return new Intent(context, RetroFitTestActivity.class);
  }

  @OnClick(R.id.btn_get) void getUsers() {
    getUsersList();
  }

  @OnClick(R.id.btn_post) void createUser() {
    addNewUser();
  }

  @OnClick(R.id.btn_single) void getSingleUser() {
    getUser();
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.retro_test);

    ButterKnife.bind(this);

    apiInterface = APIClient.getClient().create(APIInterface.class);
  }

  private void getUsersList() {

    ProgressDialog progress = new ProgressDialog(RetroFitTestActivity.this);
    progress.setMessage("Loading");
    progress.show();

    Call<UserList> call1 = apiInterface.getUsersList("2");

    call1.enqueue(new Callback<UserList>() {
      @Override public void onResponse(Call<UserList> call, Response<UserList> response) {
        UserList userList = response.body();
        Integer text = userList.page;
        Integer total = userList.total;
        Integer totalPages = userList.totalPages;

        List<UserList.Datum> datumList = userList.data;

        Toast.makeText(RetroFitTestActivity.this,
            text + " page\n" + total + " total\n" + totalPages + " totalPages\n",
            Toast.LENGTH_SHORT).show();

        Timber.e(datumList.toString());

        for (UserList.Datum datum : datumList) {
          resposneText.append(" name: " + datum.firstName);
        }

        progress.dismiss();
      }

      @Override public void onFailure(Call<UserList> call, Throwable t) {
        call.cancel();
        progress.dismiss();
      }
    });
  }

  public void addNewUser() {

    ProgressDialog progress = new ProgressDialog(RetroFitTestActivity.this);
    progress.setMessage("Loading");
    progress.show();

    User user = new User("morpheus", "leader");

    Call<User> userCall = apiInterface.create(user);

    userCall.enqueue(new Callback<User>() {
      @Override public void onResponse(Call<User> call, Response<User> response) {
        User newUser = response.body();
        resposneText.setText(
            " Name: " + newUser.name + " Job: " + newUser.job + " Created At:" + newUser.createdAt);
        progress.dismiss();
      }

      @Override public void onFailure(Call<User> call, Throwable t) {
        userCall.cancel();
        progress.dismiss();
      }
    });
  }

  public void getUser() {

    ProgressDialog progress = new ProgressDialog(RetroFitTestActivity.this);
    progress.setMessage("Loading");
    progress.show();

    Call<SingleUser> singleUserCall = apiInterface.getById(2);

    singleUserCall.enqueue(new Callback<SingleUser>() {
      @Override public void onResponse(Call<SingleUser> call, Response<SingleUser> response) {
        SingleUser singleUser = response.body();

        SingleUser.Data userData = singleUser.data;

        resposneText.setText(
            "First Name: " + userData.firstName + " Last Name: " + userData.lastName
        );
        progress.dismiss();
      }

      @Override public void onFailure(Call<SingleUser> call, Throwable t) {
        singleUserCall.cancel();
        progress.dismiss();
      }
    });
  }
}
