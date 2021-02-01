package com.example.freon.b645052thre;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.example.freon.b645052thre.App.CHANNEL_ID;

public class LittleIntentService extends IntentService {
    public static final String TAG = "LittleIntentService";

    private PowerManager.WakeLock wakeLock;

    /**
     * @param name
     * @deprecated
     */
    public LittleIntentService() {
        super("LittleIntentService");
        setIntentRedelivery(true);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");

        PowerManager powerManager = (PowerManager)getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                "LittleApp:Wakelock");
        wakeLock.acquire();
        Log.d(TAG, "Wakelock acquired");

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                    .setContentTitle("Little IntentService")
                    .setContentText("Running...")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .build();
            startForeground(1, notification);
        }
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent");

        String input = intent.getStringExtra("inputExtra");

        for(int i = 0; i < 10; i++ ){
            Log.d(TAG, input + " - " + i);
            SystemClock.sleep(500);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDescroy");

        wakeLock.release();
        Log.d(TAG, "Wakelock released");
    }
}
