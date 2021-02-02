package com.example.freon.b625012date;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void onGetDate(View view) {
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();

        calendar.add(Calendar.DATE, 3);
        calendar.add(Calendar.MONTH, 12);
        calendar.add(Calendar.YEAR, 0);
        Date future = calendar.getTime();

        textView.setText(
                "Today: " + today + "\n"
                + "Future: " + future
        );
    }
}