package com.example.freon.b607210noti;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;

import java.util.ArrayList;
import java.util.List;

import static com.example.freon.b607210noti.App.CHANNEL_1_ID;
import static com.example.freon.b607210noti.App.CHANNEL_2_ID;
import static com.example.freon.b607210noti.App.CHANNEL_3_ID;
import static com.example.freon.b607210noti.App.GROUP_1_ID;


public class MainActivity extends AppCompatActivity {
    static List<Message> MESSAGES = new ArrayList<>();
    private static NotificationManagerCompat notificationManager;

    EditText editTextTitle;
    EditText editTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextMessage = findViewById(R.id.editTextMessage);

        notificationManager = NotificationManagerCompat.from(this);

        MESSAGES.add(new Message("Good morning", "Jim"));

    }

    public static void sendChannel1Notification(Context context) {
        Intent activityIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, activityIntent, 0);

        RemoteInput remoteInput = new RemoteInput.Builder("key_text_reply")
                .setLabel("Your answer...")
                .build();

        Intent replyIntent = new Intent(context, DirectReplyReceiver.class);
        PendingIntent replyPendingIntent = PendingIntent.getBroadcast(context,
                0, replyIntent, 0);

        NotificationCompat.Action replyAction = new NotificationCompat.Action.Builder(
                R.drawable.ic_replay,
                "Replay",
                replyPendingIntent
        ).addRemoteInput(remoteInput).build();

        NotificationCompat.MessagingStyle messagingStyle =
                new NotificationCompat.MessagingStyle("Me");
        messagingStyle.setConversationTitle("Group Chat");

        for (Message chatMessage : MESSAGES) {
            NotificationCompat.MessagingStyle.Message notificationMessage =
                    new NotificationCompat.MessagingStyle.Message(
                            chatMessage.getText(),
                            chatMessage.getTimestamp(),
                            chatMessage.getSender()
                    );
            messagingStyle.addMessage(notificationMessage);
        }

        Notification notification = new
                NotificationCompat.Builder(context, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_channel_1_24)
                .setStyle(messagingStyle)
                .addAction(replyAction)
                .setColor(Color.BLUE)

                .setPriority(Notification.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);


        notificationManager.notify(1, notification);
    }

    public void onSendChannel1(View view) {
        if (!notificationManager.areNotificationsEnabled()) {
            openNotificationSettings();
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                && isChannelBlocked(CHANNEL_1_ID)){
            openChannelSettings(CHANNEL_1_ID);
            return;
        }

        sendChannel1Notification(this);
    }

    public void onSendChannel2(View view) {
        String title1 = "Title 1";
        String message1 = "Message 1";
        String title2 = "Title 2";
        String message2 = "Message 2";

        Notification notification1 = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_channel_2_24)
                .setContentTitle(title1)
                .setContentText(message1)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setGroup("example_group")
                .build();

        Notification notification2 = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_channel_2_24)
                .setContentTitle(title2)
                .setContentText(message2)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setGroup("example_group")
                .build();

        Notification notificationSummary = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_replay)
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine(title2 + " " + message2)
                        .addLine(title1 + " " + message1)
                        .setBigContentTitle("2 new messages")
                        .setSummaryText("user@little.com"))
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setGroup("little_group")
                .setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_CHILDREN)
                .setGroupSummary(true)
                .build();

        SystemClock.sleep(2000);
        notificationManager.notify(2, notification1);
        SystemClock.sleep(2000);
        notificationManager.notify(3, notification2);
        SystemClock.sleep(2000);
        notificationManager.notify(4, notificationSummary);
    }

    private void openNotificationSettings() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Intent intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, getOpPackageName());
            startActivity(intent);
        } else {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.parse("package:" + getOpPackageName()));
            startActivity(intent);
        }
    }

    @RequiresApi(26)
    private boolean isChannelBlocked(String channelId) {
        NotificationManager manager = getSystemService(NotificationManager.class);
        NotificationChannel channel = manager.getNotificationChannel(channelId);

        return channel != null && channel.getImportance() == NotificationManager.IMPORTANCE_NONE;
    }

    @RequiresApi(26)
    private void openChannelSettings(String channelId) {
        Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, getOpPackageName());
        intent.putExtra(Settings.EXTRA_CHANNEL_ID, channelId);
        startActivity(intent);
    }

    public void onDeleteChannels(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.deleteNotificationChannel(CHANNEL_3_ID);
        }
    }

    public void onDeleteGroups(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.deleteNotificationChannelGroup(GROUP_1_ID);
        }
    }
}