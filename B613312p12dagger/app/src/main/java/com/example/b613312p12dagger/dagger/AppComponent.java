package com.example.b613312p12dagger.dagger;

import com.example.b613312p12dagger.car.Driver;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DriverModule.class)
public interface AppComponent {

    Driver getDriver();
}
