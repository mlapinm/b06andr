package com.example.freon.b601219interf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LittleDialog.OnClickListener {
    Button button;
    TextView textView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        textView.setText("" + count);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LittleDialog dialog = new LittleDialog();
                dialog.show(getSupportFragmentManager(), "little dialog");
            }
        });
    }

    @Override
    public void onOkClick() {
        count += 1;
        textView.setText("" + count);
    }
}