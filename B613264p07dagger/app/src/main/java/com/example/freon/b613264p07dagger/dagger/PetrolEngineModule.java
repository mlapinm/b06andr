package com.example.freon.b613264p07dagger.dagger;

import com.example.freon.b613264p07dagger.car.Engine;
import com.example.freon.b613264p07dagger.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract Engine bindEngine(PetrolEngine engine);
}
