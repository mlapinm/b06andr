package com.example.b613262p07dagger;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b613262p07dagger.car.Car;
import com.example.b613262p07dagger.dagger.CarComponent;
import com.example.b613262p07dagger.dagger.DaggerCarComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent component = DaggerCarComponent.create();
        component.inject(this);

        car.drive();
    }
}