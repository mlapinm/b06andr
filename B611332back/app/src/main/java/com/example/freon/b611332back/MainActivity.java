package com.example.freon.b611332back;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    long timePress;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        if(timePress + 2000 > System.currentTimeMillis()){
            toast.cancel();
            super.onBackPressed();
        }else {
            timePress = System.currentTimeMillis();
            toast = Toast.makeText(this, "Pressed", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}