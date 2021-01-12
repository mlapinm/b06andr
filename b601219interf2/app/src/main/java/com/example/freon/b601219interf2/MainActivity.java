package com.example.freon.b601219interf2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LittleDialog.OnClickListener {
    int count = 0;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LittleDialog littleDialog = new LittleDialog();
                littleDialog.show(getSupportFragmentManager(), "open dialog");
            }
        });
    }

    @Override
    public void onOkClick() {
        count += 1;
        textView.setText("" + count);
    }
}