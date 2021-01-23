package com.example.b611502wifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiManager = (WifiManager) getApplicationContext()
                .getSystemService(Context.WIFI_SERVICE);
    }

    public void wifiOn(View view) {
        wifiManager.setWifiEnabled(true);
        Toast.makeText(this, "wifi on", Toast.LENGTH_SHORT).show();
    }

    public void wifiOff(View view) {
        wifiManager.setWifiEnabled(false);
        Toast.makeText(this, "wifi off", Toast.LENGTH_SHORT).show();
    }
}