package com.example.freon.b647022serv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "";
    EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
    }

    public void onButtonStart(View view) {
        String input = editTextInput.getText().toString();

        Intent serviceIntent = new Intent(this, LittleService.class);
        serviceIntent.putExtra("inputExtra", input);

        ContextCompat.startForegroundService(this, serviceIntent);

    }

    public void onButtonStop(View view) {
        Intent serviceIntent = new Intent(this, LittleService.class);
        stopService(serviceIntent);
        
    }
}