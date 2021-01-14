package com.example.freon.b607202noti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.freon.b607202noti.App.CHANNEL_1_ID;
import static com.example.freon.b607202noti.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextMessage = findViewById(R.id.editTextMessage);
    }

    public void onClickButton1(View view) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        Notification notification = new
                NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_channel_1_24)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(Notification.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);
    }

    public void onClickButton2(View view) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

        Notification notification = new
                NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_channel_2_24)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(Notification.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(2, notification);
    }
}