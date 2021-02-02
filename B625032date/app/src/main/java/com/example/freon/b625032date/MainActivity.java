package com.example.freon.b625032date;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "CountDownTimer";

    public static final long START_TIME_IN_MILLIS = 600000;

    TextView textView;
    Button buttonStart;
    Button buttonReset;

    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;
    private long endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewCountDown);
        buttonStart = findViewById(R.id.buttonStartPause);
        buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setVisibility(View.INVISIBLE);

        updateCountDownText();
    }

    public void onStartPause(View view) {
        if(timerRunning){
            pauseTimer();
        }else {
            startTimer();
        }
    }

    private void startTimer() {
        endTime = System.currentTimeMillis() + timeLeftInMillis;

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMillis = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                updateButtons();
            }
        }.start();
        Log.d(TAG, "startTimer");
        timerRunning = true;
        buttonStart.setText("pause");
        updateButtons();

    }

    private void pauseTimer() {
        Log.d(TAG, "pauseTimer");
        countDownTimer.cancel();
        timerRunning = false;
        updateButtons();

    }

    public void onReset(View view) {
        Log.d(TAG, "onReset");
        timeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        updateButtons();
    }

    private void updateCountDownText(){

        long minutes = timeLeftInMillis / 1000 / 60;
        long seconds = timeLeftInMillis / 1000 % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),
                "%02d : %02d", minutes, seconds);

        textView.setText(timeLeftFormatted);
    }

    void updateButtons(){
        if(timerRunning){
            buttonReset.setVisibility(View.INVISIBLE);
            buttonStart.setText("Pause");
        }else{
            buttonStart.setText("Start");

            if(timeLeftInMillis < 1000){
                buttonStart.setVisibility(View.INVISIBLE);
            }else {
                buttonStart.setVisibility(View.VISIBLE);
            }

            if(timeLeftInMillis < START_TIME_IN_MILLIS){
                buttonReset.setVisibility(View.VISIBLE);
            }else{
                buttonReset.setVisibility(View.INVISIBLE);
            }
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        outState.putLong("timeLeftInMillis", timeLeftInMillis);
        outState.putBoolean("timerRunning", timerRunning);
        outState.putLong("endTime", endTime);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState");
        timeLeftInMillis = savedInstanceState.getLong("timeLeftInMillis");
        timerRunning = savedInstanceState.getBoolean("timerRunning");
        endTime = savedInstanceState.getLong("endTime");

        updateCountDownText();
        updateButtons();

        if(timerRunning){
            endTime = savedInstanceState.getLong("endTime");
            timeLeftInMillis = endTime - System.currentTimeMillis();
            startTimer();
        }
    }
}