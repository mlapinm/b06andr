package com.example.freon.b613142gson2;

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
        Address1 address1 = new Address1("Germany", "Berlin");

        Employee employee1 = new Employee("John",
                30,
                "john@gmail.com", address1);

        String json1 = gson.toJson(employee1, Employee.class);
        textView.setText(json1);
// 2
        String json2 = "";
        json2 += "{";
        json2 += "\"address\": {";
        json2 += "\"city\": \"Bonn\",";
        json2 += "\"country\": \"Germany\"";
        json2 += "},";
        json2 += "\"age\": 31,";
        json2 += "\"first_name\": \"Jenny\",";
        json2 += "\"mail\": \"john@gmail.com\"";
        json2 += "}";

        Employee employee2 = gson.fromJson(json2, Employee.class);
        String json3 = gson.toJson(employee2, Employee.class);
        textView2.setText(json3);

    }
}