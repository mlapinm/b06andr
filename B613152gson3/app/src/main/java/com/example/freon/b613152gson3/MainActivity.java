package com.example.freon.b613152gson3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

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
        Address address1 = new Address("Germany", "Berlin");

        List<FamilyMember> familys1 = new ArrayList<>();
        familys1.add(new FamilyMember("Wife", 30));
        familys1.add(new FamilyMember("Daughter", 5));

        Employee employee1 = new Employee("John", 30,
                "john@gmail.com", address1, familys1);

        String json1 = gson.toJson(employee1, Employee.class);
        textView.setText(json1);
// 2
        String json2 = "";
        json2 += "{";
        json2 += "\"address\": {";
        json2 += "\"city\": \"Berlin\",";
        json2 += "\"country\": \"Germany\"";
        json2 += "},";
        json2 += "\"age\": 31,";
        json2 += "\"family\": [";
        json2 += "{";
        json2 += "\"age\": 30,";
        json2 += "\"role\": \"Hasband\"";
        json2 += "},";
        json2 += "{";
        json2 += "\"age\": 5,";
        json2 += "\"role\": \"Daughter\"";
        json2 += "}";
        json2 += "],";
        json2 += "\"first_name\": \"Jenny\",";
        json2 += "\"mail\": \"jenny@gmail.com\"";
        json2 += "}";

        Employee employee2 = gson.fromJson(json2, Employee.class);
        String json3 = gson.toJson(employee2, Employee.class);
        textView2.setText(json3);

    }

}