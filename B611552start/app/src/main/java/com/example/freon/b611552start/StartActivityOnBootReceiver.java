package com.example.freon.b611552start;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StartActivityOnBootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
        if(Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
        }
    }
}
