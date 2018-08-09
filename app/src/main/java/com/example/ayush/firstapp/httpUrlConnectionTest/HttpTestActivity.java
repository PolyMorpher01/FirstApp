package com.example.ayush.firstapp.httpUrlConnectionTest;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.ayush.firstapp.R;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import timber.log.Timber;

public class HttpTestActivity extends AppCompatActivity {

  @BindView(R.id.btn_get) Button button;
  @BindView(R.id.txt_response) TextView responseText;

  public static Intent getIntent(Context context) {
    return new Intent(context, HttpTestActivity.class);
  }

  @OnClick(R.id.btn_get) void getData() {
    new FetchData().execute();
  }

  @OnClick(R.id.btn_post) void postData() {
    new PostData().execute();
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.http_test);
    ButterKnife.bind(this);
  }

  class FetchData extends AsyncTask<Void, Void, String> {

    @Override protected String doInBackground(Void... params) {

      HttpURLConnection urlConnection = null;
      BufferedReader reader = null;

      String jsonStr = null;

      try {

        URL url = new URL("https://reqres.in/api/users?page=2");

        // Create the request , and open the connection
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        // Read the input stream into a String
        InputStream inputStream = urlConnection.getInputStream();
        StringBuffer buffer = new StringBuffer();
        if (inputStream == null) {
          // Nothing to do.
          return null;
        }
        reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader.readLine()) != null) {
          buffer.append(line + "\n");
        }

        if (buffer.length() == 0) {
          return null;
        }

        jsonStr = buffer.toString();
        return jsonStr;
      } catch (IOException e) {

        Timber.e("Error");
        return null;
      } finally {

        if (urlConnection != null) {
          urlConnection.disconnect();
        }
        if (reader != null) {

          try {

            reader.close();
          } catch (final IOException e) {

            Timber.e("error closing stream");
          }
        }
      }
    }

    ProgressDialog progress;
    protected void onPreExecute() {
      progress = new ProgressDialog(HttpTestActivity.this);
      progress.setMessage("Loading");
      progress.show();
    }

    @Override protected void onPostExecute(String string) {
      progress.dismiss();
      super.onPostExecute(string);
      responseText.setText(string);
    }
  }

  class PostData extends AsyncTask<String, Void, String> {

    @Override protected String doInBackground(String... strings) {
      {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        String jsonStr = null;

        try {

          URL url = new URL("https://reqres.in/api/users");

          // Create the request , and open the connection
          urlConnection = (HttpURLConnection) url.openConnection();
          urlConnection.setRequestMethod("POST");


          //write to post

          Map<String, String> postData = new HashMap<>();
          postData.put("name", "morpheus");
          postData.put("job", "leader");
          Timber.i(postData.toString());

          //send the POST out
          PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
          out.print(postData);
          out.close();

          //urlConnection.getResponseCode();
          urlConnection.connect();
          // Read the input stream into a String
          InputStream inputStream = urlConnection.getInputStream();
          StringBuffer buffer = new StringBuffer();
          if (inputStream == null) {
            // Nothing to do.
            return null;
          }
          reader = new BufferedReader(new InputStreamReader(inputStream));

          String line;
          while ((line = reader.readLine()) != null) {
            buffer.append(line + "\n");
          }

          if (buffer.length() == 0) {
            // Stream was empty.  No point in parsing.
            return null;
          }

          jsonStr = buffer.toString();
          Timber.w(jsonStr);
          return jsonStr;
        } catch (IOException e) {
          e.printStackTrace();
          Timber.e("Error");
          return null;
        } finally {

          if (urlConnection != null) {
            urlConnection.disconnect();
          }
          if (reader != null) {

            try {

              reader.close();
            } catch (final IOException e) {
              Timber.e(e);
              Timber.e("error closing stream");
            }
          }
        }
      }
    }

    ProgressDialog progress;
    protected void onPreExecute() {
      progress = new ProgressDialog(HttpTestActivity.this);
      progress.setMessage("Loading");
      progress.show();
    }


    @Override protected void onPostExecute(String string) {
      progress.dismiss();
      super.onPostExecute(string);
      responseText.setText(string);
    }
  }
}
