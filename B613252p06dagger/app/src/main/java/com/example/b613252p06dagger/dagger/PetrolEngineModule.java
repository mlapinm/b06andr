package com.example.b613252p06dagger.dagger;

import com.example.b613252p06dagger.car.Engine;
import com.example.b613252p06dagger.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract Engine bindEngine(PetrolEngine engine);
}
