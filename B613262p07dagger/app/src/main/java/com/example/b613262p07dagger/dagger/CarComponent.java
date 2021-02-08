package com.example.b613262p07dagger.dagger;


import com.example.b613262p07dagger.MainActivity;
import com.example.b613262p07dagger.car.Car;

import dagger.Component;

@Component(modules = {WheelModule.class, DieselEngineModule.class})
public interface CarComponent {

    Car getCar();

    void inject(MainActivity mainActivity);

}
