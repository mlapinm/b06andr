package com.example.freon.b645032thre;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;

public class LittleHandlerThread extends HandlerThread {
    public static final String TAG = "LittleHandlerThread";

    public static final int LITTLE_TASK = 1;

    private Handler handler;

    public LittleHandlerThread() {
        super("LittleHandlerThread",
                Process.THREAD_PRIORITY_BACKGROUND);
    }

    @SuppressLint("HandlerLeak")
    @Override
    protected void onLooperPrepared() {
        handler = new Handler(){

            @Override
            public void handleMessage(@NonNull Message msg) {

                switch (msg.what) {
                    case LITTLE_TASK:
                        Log.d(TAG, "Example Task, arg1: "
                                + msg.arg1
                                + ", obj: " + msg.obj
                        );
                        for (int i = 0; i < 4; i++) {
                            Log.d(TAG,
                                    "handleMessage: " + i
                            );
                            SystemClock.sleep(1000);
                        }
                        break;
                }
            }
        };
    }

    public Handler getHandler() {
        return handler;
    }
}
