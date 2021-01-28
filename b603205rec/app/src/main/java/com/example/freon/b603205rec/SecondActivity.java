package com.example.freon.b603205rec;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView1 = findViewById(R.id.textViewSecond1);
        textView2 = findViewById(R.id.textViewSecond2);
        imageView = findViewById(R.id.imageView2);

        Intent intent = getIntent();
        String text1, text2;
        int icon = intent.getIntExtra(MainActivity.EXTRA_ICON, 0);
        text1 = intent.getStringExtra(MainActivity.EXTRA_TEXT1);
        text2 = intent.getStringExtra(MainActivity.EXTRA_TEXT2);
        imageView.setImageResource(icon);
        textView1.setText(text1);
        textView2.setText(text2);

    }
}