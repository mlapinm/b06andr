package com.example.b609092imag;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private TextSwitcher textSwitcher;
    private Button buttonNext;
    private int stringIndex = 0;
    private String[] strings = {
            "ONE",
            "TWO",
            "THREE",
            "FOUR",
            "FIVE",
            "SIX",
            "SEVEN"
    };
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSwitcher = findViewById(R.id.textSwitcher1);
        buttonNext = findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stringIndex == strings.length - 1){
                    stringIndex = 0 ;
                    textSwitcher.setText(strings[stringIndex]);
                }else{
                    textSwitcher.setText(strings[++stringIndex]);
                }
            }
        });

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView = new TextView(MainActivity.this);
                textView.setTextColor(Color.BLUE);
                textView.setTextSize(50);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);

                return textView;
            }
        });

        textSwitcher.setText(strings[stringIndex]);
    }
}