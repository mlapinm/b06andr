package com.example.freon.b611362sound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.boytronic_I_will_survive);

    }

    public void onClickPlay(View view) {
        mediaPlayer.start();
    }

    public void onClickPause(View view) {
        mediaPlayer.pause();
    }

    public void onClickStop(View view) {
        mediaPlayer.stop();
    }
}