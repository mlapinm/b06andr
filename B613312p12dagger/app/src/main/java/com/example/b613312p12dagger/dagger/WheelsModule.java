package com.example.b613312p12dagger.dagger;

import com.example.b613312p12dagger.car.Rims;
import com.example.b613312p12dagger.car.Tires;
import com.example.b613312p12dagger.car.Wheels;

import dagger.Module;
import dagger.Provides;

@Module
public class WheelsModule {

    @Provides
    static Rims provideRims(){
        return  new Rims();
    }

    @Provides
    static Tires provideTires(){
        Tires tires = new Tires();
        tires.inflate();
        return new Tires();
    }

    @Provides
    static Wheels provideWheels(Rims rims, Tires tires){
        return new Wheels(rims, tires);

    }


}
