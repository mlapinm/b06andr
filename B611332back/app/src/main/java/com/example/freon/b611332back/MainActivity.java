package com.example.freon.b611332back;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    long timePress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        if(timePress + 2000 > 0){
            super.onBackPressed();
        }else {
            timePress = 0;
            Toast toast = Toast.makeText(this, "Pressed", Toast.LENGTH_SHORT);
            toast.cancel();
            toast.show();
        }
    }
}