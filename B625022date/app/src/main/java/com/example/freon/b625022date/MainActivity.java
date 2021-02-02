package com.example.freon.b625022date;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final long START_TIME_IN_MILLIS = 600000;

    TextView textView;
    Button buttonStart;
    Button buttonReset;

    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        buttonStart = findViewById(R.id.buttonStart);
        buttonReset = findViewById(R.id.buttonReset);
    }

    public void onStart(View view) {
        if(timerRunning){
            pauseTimer();
        }else {
            startTimer();
        }
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMillis = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                buttonStart.setText("Start");
                buttonStart.setVisibility(View.INVISIBLE);
                buttonReset.setVisibility(View.VISIBLE);
            }
        }.start();
        timerRunning = true;
        buttonStart.setText("pause");
        buttonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        buttonStart.setText("Start");
        buttonReset.setVisibility(View.VISIBLE);
    }

    public void onReset(View view) {
        timeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        buttonReset.setVisibility(View.INVISIBLE);
    }

    private void updateCountDownText(){
        long minutes = timeLeftInMillis / 1000 / 60;
        long seconds = timeLeftInMillis / 1000 % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),
                "%02d : %02d", minutes, seconds);

        textView.setText(timeLeftFormatted);
    }
}