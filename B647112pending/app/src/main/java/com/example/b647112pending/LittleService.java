package com.example.b647112pending;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import static com.example.b647112pending.MainActivity.PARAM_PENDING_INTENT;

public class LittleService extends Service {
    public static final String TAG = "LittleService";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand " + startId);

        PendingIntent pendingIntent = intent.getParcelableExtra(PARAM_PENDING_INTENT);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pendingIntent.send(MainActivity.STATUS_START);
                    Thread.sleep(2500);
                    pendingIntent.send(MainActivity.STATUS_END);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (PendingIntent.CanceledException e) {
                    e.printStackTrace();
                }
                stop(startId);
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    void stop(int startId){
        stopSelfResult(startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
