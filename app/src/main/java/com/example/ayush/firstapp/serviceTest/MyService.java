package com.example.ayush.firstapp.serviceTest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;
import com.example.ayush.firstapp.R;

public class MyService extends Service {

  MediaPlayer mediaPlayer;

  NotificationManager notificationManager;

  @Nullable @Override public IBinder onBind(Intent intent) {
    return null;
  }

  @Override public void onCreate() {
    super.onCreate();

   /* notificationManager =
        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);*/

    mediaPlayer = MediaPlayer.create(this, R.raw.sample_music);

    mediaPlayer.setLooping(false);
  }

  @Override public int onStartCommand(Intent intent, int flags, int startId) {

    createNotification(1, R.drawable.ic_notifications, "Service started", "Music playing");

    Toast.makeText(this, "service Started", Toast.LENGTH_SHORT).show();

    mediaPlayer.start();

    return START_NOT_STICKY;
  }

  @Override public void onDestroy() {
    super.onDestroy();

    cancelNotification(1);

    Toast.makeText(this, "Service destroyed", Toast.LENGTH_SHORT).show();

    mediaPlayer.stop();
  }

  private void createNotification(int nId, int iconRes, String title, String body) {

    Intent notificationIntent = ServiceTestActivity.getIntent(this);

    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

    Notification notification = new NotificationCompat.Builder(this, "myChannel")
        .setSmallIcon(iconRes)
        .setContentTitle(title)
        .setContentText(body)
        .setStyle(new NotificationCompat.BigTextStyle().bigText("This is a long text"))
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setContentIntent(pendingIntent)
        .build();

    //dismissible notification
    //notificationManager.notify(nId, notification);

    //foreground service with non dismissible notification
    startForeground(nId, notification);
  }

  private void cancelNotification(int nId) {
    //notificationManager.cancel(nId);

    stopForeground(true);

  }
}
