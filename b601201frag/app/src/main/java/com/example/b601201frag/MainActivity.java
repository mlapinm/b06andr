package com.example.b601201frag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LittleFragment littleFragment = LittleFragment
                .newInstance("little text ", 1234);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container1, littleFragment)
                .commit();
    }
}
