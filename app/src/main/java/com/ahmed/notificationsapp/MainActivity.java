package com.ahmed.notificationsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;

    private static final String CHANNEL_ID = "some_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn_show_notification);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpNotification();

            }
        });
    }

    private void setUpNotification() {

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"Notification One", NotificationManager.IMPORTANCE_MAX);

        Intent intent = new Intent(MainActivity.this, MainActivity.class);

        Notification.Builder builder = new Notification.Builder(getApplicationContext())
                .setContentTitle("Title of the notification")
                .setContentText("Something something")
                .setAutoCancel(true)
                .setContentIntent(PendingIntent.getActivity(getApplicationContext(),13,intent,0))
                .setStyle(new Notification.BigTextStyle().bigText("Title of the notification Title of the notification Title of the notification Title of the notification Title of the notification"))
                .setSmallIcon(R.drawable.ic_baseline_adb_24)
                .setChannelId(CHANNEL_ID);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
        notificationManager.notify(1, builder.build());
    }
}