package com.example.freon.b645062thre;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class LittleJobIntentService extends JobIntentService {
    public static final String TAG = "LittleJobIntentService";

    static void enqueueWork(Context context, Intent work){
        enqueueWork(context, LittleJobIntentService.class, 123, work);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "OnCreate");
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.d(TAG, "onHandleWork");

        String input = intent.getStringExtra("inputExtra");

        for(int i = 0; i < 10; i++){
            Log.d(TAG, input + " - " + i);

            if(isStopped()){
                return;
            }
            SystemClock.sleep(1500);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public boolean onStopCurrentWork() {
        Log.d(TAG, "onStopCurrentWork");
        return super.onStopCurrentWork();
    }
}
