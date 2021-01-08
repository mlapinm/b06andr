package com.example.b601201frag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LittleFragment littleFragment = new LittleFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container1, littleFragment)
                .commit();
    }
}
