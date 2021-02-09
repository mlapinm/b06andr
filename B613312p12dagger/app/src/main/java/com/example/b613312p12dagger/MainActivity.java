package com.example.b613312p12dagger;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b613312p12dagger.car.Car;
import com.example.b613312p12dagger.dagger.ActivityComponent;
//import com.example.b613312p12dagger.dagger.DaggerActivityComponent;
import com.example.b613312p12dagger.dagger.DieselEngineModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car car1, car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ActivityComponent component = DaggerActivityComponent.builder()
//                .horsePower(120)
//                .engineCapacity(1400)
//                .appComponent(((LittleApp) getApplication()).getAppComponent())
//                .build();


        ActivityComponent component = ((LittleApp)getApplication())
                .getAppComponent()
                .getActivityComponent(
                        new DieselEngineModule(120)
                );

        component.inject(this);

        car1.drive();
        car2.drive();
    }
}