package com.example.freon.b605206slidr2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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


    public void lockSlide(View view) {
        slidr.lock();

    }

    public void unlockSlide(View view) {
        slidr.unlock();
    }
}