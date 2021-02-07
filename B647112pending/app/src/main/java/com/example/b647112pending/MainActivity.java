package com.example.b647112pending;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String PARAM_PENDING_INTENT = "PARAM_PENDING_INTENT";
    public static final int STATUS_START = 100;
    public static final int STATUS_END = 200;
    public static final int TASK1_CODE = 1;
    public static final int TASK2_CODE = 2;
    public static final String TAG = "LittleService";

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Log.d(TAG,"onCreate");
    }



    public void onStart(View view) {
        PendingIntent pendingResult = createPendingResult(TASK2_CODE, new Intent(),0);

        Intent intent = new Intent(this, LittleService.class);
        intent.putExtra(PARAM_PENDING_INTENT, pendingResult);
        startService(intent);
    }

    public void foo(){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(TAG, "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == STATUS_START){
            textView.setText("Status: Start");
        }

        if(resultCode == STATUS_END){
            textView.setText("Status: End");
        }

    }

    public void onResetButton(View view) {
        textView.setText("Status: Stop");
    }
}