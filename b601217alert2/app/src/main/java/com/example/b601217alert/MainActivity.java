package com.example.b601217alert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Title")
                .setMessage("Example Message")
                .setPositiveButton("Ok", null)
                .setNegativeButton("Cancel", null)
                .show();

        Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Closing", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });
    }
}