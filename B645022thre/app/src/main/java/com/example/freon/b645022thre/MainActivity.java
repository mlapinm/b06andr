package com.example.freon.b645022thre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

import static com.example.freon.b645022thre.LittleHandler.TASK_A;
import static com.example.freon.b645022thre.LittleHandler.TASK_B;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private LittleLooperThread looperThread = new LittleLooperThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStart(View view) {
        looperThread.start();
    }

    public void onStop(View view) {
        looperThread.looper.quit();
    }

    public void onTaskA(View view) {
        Message msg = Message.obtain();
        msg.what = TASK_A;
        looperThread.handler.sendMessage(msg);
    }

    public void onTaskB(View view) {
        Message msg = Message.obtain();
        msg.what = TASK_B;
        looperThread.handler.sendMessage(msg);
    }
}