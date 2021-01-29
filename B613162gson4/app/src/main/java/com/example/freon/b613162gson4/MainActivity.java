package com.example.freon.b613162gson4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view_1);
        textView2 = findViewById(R.id.text_view_2);

        Gson gson = new Gson();
// 1
        Emploee emploee1 = new Emploee(
                "John",
                30,
                "john@gmail.com",
                "1234"
        );

        String json1 = gson.toJson(emploee1);
        textView.setText(json1);

// 2
        String json2 = "";
        json2 += "{";
//        json2 += "\"firstName\":\"Jenny\",";
//        json2 += "\"age\":31,";
//        json2 += "\"mail\":\"jenny@mail.com\",";
        json2 += "\"password\":\"1234\"";
        json2 += "}";

        Emploee emploee2 = gson.fromJson(json2, Emploee.class);
        String json3 = gson.toJson(emploee2);
        textView2.setText(json3);

    }
}