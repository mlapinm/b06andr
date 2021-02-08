package com.example.b613302p11dagger.dagger;

import com.example.b613302p11dagger.car.Driver;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DriverModule.class)
public interface AppComponent {

    Driver getDriver();
}
