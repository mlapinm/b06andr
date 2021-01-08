package com.example.b601201frag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LittleFragment littleFragment = new LittleFragment();

        Bundle args = new Bundle();
        args.putString("argText", "little text ");
        args.putInt("argNumber", 123);
        littleFragment.setArguments(args);

        getSupportFragmentManager().beginTransaction().replace(R.id.container1, littleFragment)
                .commit();
    }
}
