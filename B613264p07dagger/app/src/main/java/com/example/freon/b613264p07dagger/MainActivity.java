package com.example.freon.b613264p07dagger;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freon.b613264p07dagger.car.Car;
import com.example.freon.b613264p07dagger.dagger.CarComponent;
import com.example.freon.b613264p07dagger.dagger.DaggerCarComponent;
import com.example.freon.b613264p07dagger.dagger.DieselEngineModule;

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
                .dieselEngineModule(new DieselEngineModule(100))
                .build();
        component.inject(this);
        car.drive();
    }
}