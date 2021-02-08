package com.example.b613274p08dagger;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b613274p08dagger.car.Car;
import com.example.b613274p08dagger.dagger.CarComponent;
import com.example.b613274p08dagger.dagger.DaggerCarComponent;
//import com.example.b613274p08dagger.DaggerCarComponent;
//import com.example.b613274p08dagger.DieselEngineModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        CarComponent component = DaggerCarComponent.create();
//        component.inject(this);

        CarComponent component = DaggerCarComponent.builder()
                .horsePower(150)
                .engineCapacity(1400)
                .build();

        component.inject(this);
        car.drive();
    }
}