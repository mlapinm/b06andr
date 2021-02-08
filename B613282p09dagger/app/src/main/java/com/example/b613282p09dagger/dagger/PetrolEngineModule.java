package com.example.b613282p09dagger.dagger;

import com.example.b613282p09dagger.car.Engine;
import com.example.b613282p09dagger.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract Engine bindEngine(PetrolEngine engine);
}
