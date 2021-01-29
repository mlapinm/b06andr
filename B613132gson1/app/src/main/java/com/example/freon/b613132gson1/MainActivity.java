package com.example.freon.b613132gson1;

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
        Employee employee = new Employee("John", 30, "john@gmail.com");
        String json = gson.toJson(employee);
        textView.setText(json);
// 2
        String json2 = "";
        json2 += "{";
        json2 += "\"age\": 31,";
        json2 += "\"first_name\": \"Jenny\",";
        json2 += "\"mail\": \"jenny@gmail.com\"";
        json2 += "}";

        Employee employee2 = gson.fromJson(json2, Employee.class);
        String json3 = gson.toJson(employee2);
        textView2.setText(json3);


    }
}