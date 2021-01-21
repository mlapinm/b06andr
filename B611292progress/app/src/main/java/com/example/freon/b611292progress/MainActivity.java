package com.example.freon.b611292progress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final static int DELTA = 10;
    ProgressBar progressBar;

    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progessBar);
        progress = progressBar.getProgress();

    }

    public void onClickMines(View view) {
        if(progress == 0) {
            progress = 0;
        } else {
            progress -= DELTA;
        }
        progressBar.setProgress(progress);
    }


    public void onClickPlus(View view) {
        if(progress == 100) {
            progress = 100;
        } else {
            progress += DELTA;
        }
        progressBar.setProgress(progress);
    }
}