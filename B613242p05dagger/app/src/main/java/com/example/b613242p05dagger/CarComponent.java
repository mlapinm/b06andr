package com.example.b613242p05dagger;

import dagger.Component;

@Component(modules = WheelModule.class)
public interface CarComponent {

    Car getCar();

    void inject(MainActivity mainActivity);

}
