package com.example.freon.b6470725broad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class OrderedReceiver1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int resultCode = getResultCode();
        String resultData = getResultData();
        Bundle resultExtras = getResultExtras(true);
        String stringExtra = resultExtras.getString("stringExtra");

        resultCode++;
        stringExtra += "->OR1";

        String toastText = "OR1\n"
                + "resultCode: " + resultCode + "\n"
                + "resultData: " + resultData + "\n"
                + "resultExtra: " + stringExtra + "\n";

        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();

        resultData = "OR1";
        resultExtras.putString("stringExtra", stringExtra);

        setResult(resultCode, resultData, resultExtras);

        abortBroadcast();

    }
}
