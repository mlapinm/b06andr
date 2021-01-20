package com.example.freon.b611152alert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tapadoo.alerter.Alerter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShow(View view) {
        Alerter.create(this)
                .setTitle("Alert Title")
                .setText("Alert text")
                .setDuration(5000)
                .enableProgress(true)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,
                                "Alerter message", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }
}