package com.example.b617022storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    public static final String FILE_NAME = "little1.txt";
    private static final String TAG = "logging";
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }

    public void onSave(View view) {
        String text = editText.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());

            editText.getText().clear();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Toast.makeText(this,
                "saved to "
                + getFilesDir() + "/" + FILE_NAME,
                 Toast.LENGTH_SHORT).show();
    }

    public void onLoad(View view) {
        FileInputStream fis = null;

        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null){
                sb.append(text).append("\n");
            }
            editText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String log =
                "load from "
                        + getFilesDir() + "/" + FILE_NAME;
        Toast.makeText(this, log,
                Toast.LENGTH_SHORT).show();
        Log.d(TAG, log);
    }
}