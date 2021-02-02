package com.example.freon.b645062thre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

    }

    public void onEncqueueWork(View view) {
        String input = editText.getText().toString();

        Intent serviceIntent = new Intent(this, LittleJobIntentService.class);
        serviceIntent.putExtra("inputExtra", input);

        LittleJobIntentService.enqueueWork(this,serviceIntent);

    }
}