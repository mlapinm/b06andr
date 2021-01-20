package com.example.freon.b611142spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        User user;
        user = new User("Jim", 20, "jim@gmail.com");
        users.add(user);
        user = new User("Jack", 21, "jack@gmail.com");
        users.add(user);
        user = new User("Jenny", 22, "jenny@gmail.com");
        users.add(user);

        ArrayAdapter<User> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                users);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                User user = (User)adapterView.getSelectedItem();
                displayUserData(user);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

    }

    public void onClickButton(View view) {
        User user = (User)spinner.getSelectedItem();
        displayUserData(user);
    }

    private void displayUserData(User user) {
        String text = "name: " + user.name
        + "\nAge: " + user.age
        + "\nEmail: " + user.email;
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
