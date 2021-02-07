package com.example.b613252p06dagger.dagger;

import com.example.b613252p06dagger.car.DieselEngine;
import com.example.b613252p06dagger.car.Engine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DieselEngineModule {

    @Binds
    abstract Engine bindEngine(DieselEngine engine);
}
