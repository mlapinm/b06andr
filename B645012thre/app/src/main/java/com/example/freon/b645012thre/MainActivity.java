package com.example.freon.b645012thre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private Handler handler = new Handler();
    private volatile boolean isStopThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartThread(View view) {
        isStopThread = false;

        LittleThread thread = new LittleThread(10);
        thread.start();

    }

    public void onStopThread(View view) {
    }

    class LittleThread extends Thread{

        private int seconds;

        public LittleThread(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {

            for(int i=0;i<seconds;i++){
                Log.d(TAG, "startThread: " + i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}