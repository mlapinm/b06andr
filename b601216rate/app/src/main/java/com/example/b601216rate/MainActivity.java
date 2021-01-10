package com.example.b601216rate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppRate.with(this)
                .setInstallDays(0)
                .setLaunchTimes(3)
                .setRemindInterval(2)
                .monitor();
        AppRate.showRateDialogIfMeetsConditions(this);
//        AppRate.with(this).clearAgreeShowDialog();
        AppRate.with(this).showRateDialog(this);
    }
}