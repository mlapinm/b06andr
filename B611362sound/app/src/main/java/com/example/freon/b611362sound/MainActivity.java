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


    }

    public void onClickPlay(View view) {
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, R.raw.boytronic);
        }
        mediaPlayer.start();
    }

    public void onClickPause(View view) {
        if(mediaPlayer != null){
            mediaPlayer.pause();
        }
    }

    public void onClickStop(View view) {
        stopPlayer();
    }

    private void stopPlayer() {
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void finish() {
        stopPlayer();
        super.finish();
    }
}