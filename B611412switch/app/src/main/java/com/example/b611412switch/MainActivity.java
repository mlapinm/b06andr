package com.example.b611412switch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.polyak.iconswitch.IconSwitch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IconSwitch isw = findViewById(R.id.isw);

        isw.setCheckedChangeListener(new IconSwitch.CheckedChangeListener() {
            @Override
            public void onCheckChanged(IconSwitch.Checked current) {
                switch (current){
                    case LEFT:
                        Toast.makeText(MainActivity.this, "Left", Toast.LENGTH_SHORT).show();
                        break;
                    case RIGHT:
                        Toast.makeText(MainActivity.this, "Right", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}