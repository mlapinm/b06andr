package com.example.freon.b6470826broad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

import android.Manifest;

public class MainActivity extends AppCompatActivity {
    OrderedReceiver1 orderedReceiver1 = new OrderedReceiver1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter("com.example.freon.b6470826broad.LITTLE_ACTION");
        filter.setPriority(1);
        registerReceiver(orderedReceiver1, filter, Manifest.permission.VIBRATE, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(orderedReceiver1);
    }
}