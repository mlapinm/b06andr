package com.example.b613302p11dagger;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.b613302p11dagger.car.Car;
import com.example.b613302p11dagger.dagger.ActivityComponent;
import com.example.b613302p11dagger.dagger.DaggerActivityComponent;
//import com.example.b613302p11dagger.dagger.CarComponent;
//import com.example.b613302p11dagger.dagger.DaggerCarComponent;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    @Inject
    Car car1, car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        CarComponent component = DaggerCarComponent.builder()


//        ActivityComponent component = DaggerActivityComponent.builder()
//                .horsePower(150)
//                .engineCapacity(1400)
//                .appComponent(((LittleApp)getApplication()).getAppComponent())
//                .build();

        ActivityComponent component = DaggerActivityComponent.builder()
                .horsePower(120)
                .engineCapacity(1400)
                .appComponent(((LittleApp) getApplication()).getAppComponent())
                .build();


//        ActivityComponent component = DaggerActivityComponent.builer().build();



        component.inject(this);

        car1.drive();
        car2.drive();
    }
}