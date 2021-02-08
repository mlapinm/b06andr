package com.example.freon.b613264p07dagger.dagger;

import com.example.freon.b613264p07dagger.MainActivity;
import com.example.freon.b613264p07dagger.car.Car;

import dagger.Component;

@Component(modules = {WheelModule.class, DieselEngineModule.class})
public interface CarComponent {

    Car getCar();

    void inject(MainActivity mainActivity);

}
