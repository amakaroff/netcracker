package com.netcracker.alexey_makarov.model.impl;

import com.netcracker.alexey_makarov.model.Car;

/**
 * Created by Алексей on 15.10.2016.
 */
public class VolkswagenCar extends Car {

    private static final int MAX_RUN = 10000;

    public VolkswagenCar() {
    }

    public VolkswagenCar(String name, int cost) {
        super(name, cost);
        this.mileage = 0;
    }

    @Override
    public boolean isCanGo() {
        return mileage < MAX_RUN;
    }

    @Override
    public void go() {
        if (isCanGo()) {
            this.mileage += 1000;
        }
    }
}
