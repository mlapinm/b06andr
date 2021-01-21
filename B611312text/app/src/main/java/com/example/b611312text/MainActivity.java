package com.example.b611312text;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void onClickRemove(View view) {
        String text = textView.getText().toString();
        text = text.substring(0, text.length()-1);
        textView.setText(text);
    }

    public void onClickAppend(View view) {
        String text = textView.getText().toString();
        text = text + "a";
        textView.setText(text);
    }
}