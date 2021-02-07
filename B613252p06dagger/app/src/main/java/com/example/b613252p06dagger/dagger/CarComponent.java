package com.example.b613252p06dagger.dagger;

import com.example.b613252p06dagger.MainActivity;
import com.example.b613252p06dagger.car.Car;

import dagger.Component;

@Component(modules = {WheelModule.class, DieselEngineModule.class})
public interface CarComponent {

    Car getCar();

    void inject(MainActivity mainActivity);

}
