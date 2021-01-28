package com.example.freon.b605206slidr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class SecondActivity extends AppCompatActivity {
    private SlidrInterface slidr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        slidr = Slidr.attach(this);
    }

    public void onLock(View view) {
        slidr.lock();
    }

    public void onUnlock(View view) {
        slidr.unlock();
    }
}