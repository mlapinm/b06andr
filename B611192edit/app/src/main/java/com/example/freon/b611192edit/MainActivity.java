package com.example.freon.b611192edit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.santalu.maskara.widget.MaskEditText;

public class MainActivity extends AppCompatActivity {
    private MaskEditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText1);
    }

    public void showText(View view) {
        String text = editText.getText().toString();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void showRawText(View view) {
        String text = editText.getUnMasked().toString();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}