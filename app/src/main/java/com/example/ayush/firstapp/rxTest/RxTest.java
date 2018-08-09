package com.example.ayush.firstapp.rxTest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.example.ayush.firstapp.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class RxTest extends AppCompatActivity {

  private Disposable disposable;

  public static Intent getIntent(Context context) {
    return new Intent(context, RxTest.class);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.rx_test);

    ButterKnife.bind(this);

    // observable
    Observable<String> animalsObservable =
        Observable.fromArray("cat", "dog", "horse", "bee", "camel");

    // observer
    Observer<String> animalsObserver = getAnimalObserver();

    // observer subscribing to observable
    animalsObservable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .filter(s -> s.toLowerCase().startsWith("b"))
        .subscribe(animalsObserver);
  }

  @Override protected void onDestroy() {
    super.onDestroy();

    // don't send events once the activity is destroyed
    disposable.dispose();
  }

  public Observer<String> getAnimalObserver() {
    return new Observer<String>() {
      @Override public void onSubscribe(Disposable d) {
        disposable = d;
        Timber.w("on subscribe");
      }

      @Override public void onNext(String s) {
        Timber.w("Name: " + s);
      }

      @Override public void onError(Throwable e) {
        Timber.e("error: " + e.getMessage());
      }

      @Override public void onComplete() {
        Timber.w("All items emitted");
      }
    };
  }
}
