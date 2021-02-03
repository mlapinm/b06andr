package com.example.freon.b6470523broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class LittleBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if("com.example.freon.LITTLE_ACTION".equals(intent.getAction())){
            String receiveText = intent.getStringExtra("com.example.freon.b6470523broad.EXTRA_TEXT");
            Toast.makeText(context, receiveText, Toast.LENGTH_SHORT).show();
        }
    }
}
