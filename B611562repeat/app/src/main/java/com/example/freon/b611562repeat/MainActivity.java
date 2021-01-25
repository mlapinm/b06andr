package com.example.freon.b611562repeat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStart(View view) {
        runnable.run();
    }

    public void onStop(View view) {
        handler.removeCallbacks(runnable);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(MainActivity.this,
                    "This is delayed toast", Toast.LENGTH_SHORT).show();
            handler.postDelayed(this, 4000);
        }
    };
}