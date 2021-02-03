package com.example.freon.b6470725broad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    OrderedReceiver2 orderedReceiver2 = new OrderedReceiver2();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter("com.example.freon.b6470725broad.LITTLE_ACTION");
        filter.setPriority(1);
        registerReceiver(orderedReceiver2, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(orderedReceiver2);
    }
}