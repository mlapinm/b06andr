package com.example.freon.b625052date;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "CountDownTimer";

    public static final long START_TIME_IN_MILLIS = 600000;

    TextView textView;
    Button buttonStart;
    Button buttonReset;
    EditText editTextInput;
    Button buttonSet;

    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;
    private long endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.text_view_countdown);
        buttonStart = findViewById(R.id.button_start_pause);
        buttonReset = findViewById(R.id.button_reset);
        buttonReset.setVisibility(View.INVISIBLE);
        editTextInput = findViewById(R.id.edit_text_input);
        buttonSet = findViewById(R.id.button_set);


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

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor =prefs.edit();

        editor.putLong("timeLeftInMillis", timeLeftInMillis);
        editor.putBoolean("timerRunning", timerRunning);
        editor.putLong("endTime", endTime);
        editor.apply();

        if(countDownTimer != null){
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        timeLeftInMillis = prefs.getLong("timeLeftInMillis", START_TIME_IN_MILLIS);
        timerRunning = prefs.getBoolean("timerRunning", false);
        endTime = prefs.getLong("endTime", 0);
        Log.d(TAG,"onStart " + timerRunning);

        updateCountDownText();
        updateButtons();

        if(timerRunning){
            timeLeftInMillis = endTime - System.currentTimeMillis();

            if(timeLeftInMillis < 0){
                timeLeftInMillis = 0;
                timerRunning = false;
                updateCountDownText();
                updateButtons();
            }else {
                startTimer();
            }
        }
    }


    public void onSet(View view) {
        String input = editTextInput.getText().toString().trim();
        if(input.length()==0){
            return;
        }
        long millisInput = Long.parseLong(input) * 60000;
        if(millisInput == 0){
            return;
        }

        timeLeftInMillis = millisInput;
        updateCountDownText();
    }
}