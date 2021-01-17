package com.example.b609102fad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.tomer.fadingtextview.FadingTextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private FadingTextView fadingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fadingTextView = findViewById(R.id.fading_text_view);


    }

    public void onClickButton(View view) {
        String[] little2 = {
                "And",
                "this",
                "is",
                "little 2",
        };
        fadingTextView.setTexts(little2);
        fadingTextView.setTimeout(300, TimeUnit.MILLISECONDS);

    }
}