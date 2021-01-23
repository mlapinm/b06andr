package com.example.b611462rate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rateMe(View view) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + "com.android.chrome")));
        }catch (ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id="
                    + getPackageName())));
        }
    }
}