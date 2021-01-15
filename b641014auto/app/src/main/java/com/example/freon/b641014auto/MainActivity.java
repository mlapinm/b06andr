package com.example.freon.b641014auto;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<CountryItem> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillCountryList();

        AutoCompleteTextView editText = findViewById(R.id.actv);
        AutoCompleteCountryAdapter adapter = new AutoCompleteCountryAdapter(this, countryList);
        editText.setAdapter(adapter);
    }

    private void fillCountryList() {
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("Afghanistan", R.drawable.flag_afghanistan));
        countryList.add(new CountryItem("Albania", R.drawable.flag_albania));
        countryList.add(new CountryItem("Algeria", R.drawable.flag_algeria));
        countryList.add(new CountryItem("Andorra", R.drawable.flag_andorra));
        countryList.add(new CountryItem("Angola", R.drawable.flag_angola));
    }
}