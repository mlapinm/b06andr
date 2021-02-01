package com.example.freon.b645022thre;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class LittleLooperThread extends Thread {

    public static final String TAG = "LittleLooperThread";

    public Looper looper;
    public Handler handler;

    @Override
    public void run() {
        Looper.prepare();

        looper = Looper.myLooper();

        handler = new LittleHandler();

        Looper.loop();

        Log.d(TAG, "End of run()");
    }
}
