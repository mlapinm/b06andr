package com.example.freon.b645032thre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import static com.example.freon.b645032thre.LittleHandlerThread.LITTLE_TASK;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private LittleHandlerThread handlerThread = new LittleHandlerThread();

    private LittleRunnable1 runnable1 = new LittleRunnable1();
    private Object token = new Object();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handlerThread.start();
    }

    public void onWork(View view) {
        Message msg = Message.obtain(handlerThread.getHandler());
        msg.what = LITTLE_TASK;
        msg.arg1 = 23;
        msg.obj = "Obj String";
//        msg.setData();

        msg.sendToTarget();
//        handlerThread.getHandler().sendEmptyMessage(1);
        handlerThread.getHandler().postAtTime(runnable1, token, SystemClock.uptimeMillis());
        handlerThread.getHandler().post(runnable1);
//        handlerThread.getHandler().post(new LittleRunnable1());
//        handlerThread.getHandler().postAtFrontOfQueue(new LittleRunnable2());
    }

    public void onRemoveMessage(View view) {
        handlerThread.getHandler().removeCallbacks(runnable1, token);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handlerThread.quit();
    }

    static class LittleRunnable1 implements Runnable{
        @Override
        public void run() {
            for(int i = 0; i < 4; i++){
                Log.d(TAG, "Runnable1: " + i);
                SystemClock.sleep(500);
            }
        }
    }

    static class LittleRunnable2 implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 4; i++){
                Log.d(TAG, "Runnable2: " + i);
                SystemClock.sleep(500);
            }
        }
    }

}